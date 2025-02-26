import org.apache.pdfbox.multipdf.PDFMergerUtility;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;

public class PDFMerger {
    public static void main(String[] args) {
        System.out.println("____________________________________");
        System.out.println("   GabungPDF by Arwildo.com");
        System.out.println("____________________________________");
        
        try {
            // Ambil current directory
            Path currentPath = Paths.get(".");
            
            // List semua folder
            Files.list(currentPath)
                .filter(Files::isDirectory)
                .filter(path -> path.getFileName().toString().matches("\\d+")) // Filter folder dengan angka saja
                .forEach(folder -> {
                    try {
                        mergePDFsInFolder(folder);
                    } catch (IOException e) {
                        System.err.println("Gagal memproses folder " + folder + ": " + e.getMessage());
                    }
                });
                
        } catch (IOException e) {
            System.err.println("Terjadi kesalahan: " + e.getMessage());
        }
        
        System.out.println("____________________________________");
    }

    private static void mergePDFsInFolder(Path folder) throws IOException {
        PDFMergerUtility merger = new PDFMergerUtility();
        String folderName = folder.getFileName().toString();
        
        // Set output file di current directory
        merger.setDestinationFileName(folderName + ".pdf");
        
        // List dan sort PDF files
        File[] pdfFiles = folder.toFile().listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));
        if (pdfFiles == null || pdfFiles.length == 0) {
            System.out.println("Tidak ada file PDF di folder " + folderName);
            return;
        }
        
        Arrays.sort(pdfFiles);
        
        // Add semua PDF ke merger
        for (File pdf : pdfFiles) {
            merger.addSource(pdf);
        }
        
        // Merge!
        merger.mergeDocuments(null);
        System.out.println("Berhasil menggabungkan PDF dari folder " + folderName);
    }
} 