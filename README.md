# GabungPDF
Tool untuk menggabungkan beberapa PDF menjadi satu.
Jalankan pada folder utama dan tool akan menggabungkan pdf-pdf didalam sub-folder dengan
struktur seperti berikut :

```
/folder-utama
  /3112
    - file1.pdf
    - file2.pdf
  /3113
    - doc1.pdf
    - doc2.pdf
  - 3112.pdf (hasil merge)
  - 3113.pdf (hasil merge)
```

## How to Build
- Pastikan Java JDK 15 sudah terinstall, silahakan download dari Bellsoft JDK 15 yang Full
- Buildernya menggunakan Ant
- Build menggunakan 'ant jar'