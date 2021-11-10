# Tutorial APAP

## Authors

* **Muhammad Rakha Zachrie** - *1906353795* - *A*

---
## Tutorial 5
### Jawaban Pertanyaan
1. Apa itu Postman? Apa Kegunaannya?  
Postman adalah platform API untuk membuat dan menggunakan API. Postman menyederhanakan tiap langkah pada API
lifecycle. API memiliki fitur API repository, tools, Intelligence, workspaces, dan integrations. Postman digunakan untuk
melakukan testing API.
2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.  
@JsonIgnoreProperties digunakan pada class untuk menandai atribut/properti atau daftar properti
yang akan diabaikan.  
@JsonProperty digunakan untuk memetakan nama properti dengan kunci JSON pada serialization
atau menunjukkan nama properti di JSON.  
3. Apa kegunaan atribut WebClient?  
WebClient digunakan untuk melakukan HTTP request. WebClient merupakan bagian dari Spring's
web reactive framework. WebClient juga digunakan untuk membangun aplikasi yang reactive dan
non-blocking.
4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?  
ResponseEntity mewakili seluruh respon pada HTTP yaitu body, header, dan status. ResponseEntitiy
digunakan untuk mengontrol respon HTTP seperti header dan status.  
BindingResult adalah objek dari Spring yang menyimpan hasil validasi dan berisi error yang mungkin terjadi.
---
## Tutorial 3
### Jawaban Pertanyaan
1. Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model
   (@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)  
@AllArgsConstructor menghasilkan semua constructor yang membutuhkan argumen; @NoArgsConstructor menghasilkan semua noArgs constructor;
@Setter menghasilkan setter secara otomatis; @Getter menghasilkan getter secara otomatis; @Entity membuat suatu class ditentukan menjadi entitas;
@Table berguna untuk menentukan detail table yang digunakan untuk entitas dalam database
2. Pada class CabangDB, terdapat method findByNoCabang, apakah kegunaan dari method
   tersebut?  
Kegunaan dari method findByNoCabang adalah untuk mencari Cabang berdasarkan nomor cabang yang diberikan
3. Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn  
@JoinTable digunakan untuk pemetaan many-to-many dan one-to-many  
@JoinColumn digunakan untuk membuat gabungan beberapa kolom
4. Pada class PegawaiModel, digunakan anotasi @JoinColumn pada atribut cabang, apa
   kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa
   perbedaan nullable dan penggunaan anotasi @NotNull  
name merupakan nama dari foreign key; referencedColumnName merupakan nama dari kolom yang direferenced oleh foreign key;
nullable digunakan untuk menentukan apakah foreign key nullable atau tidak; @NotNull digunakan agar column tersebut tidak bisa null
5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER  
FetchType.LAZY untuk mengambil entitas pada database seefisien mungkin  
FetchType.EAGER untuk mengambil seluruh elemen dari relationship ketika memilih root entity  
CascadeType.ALL cascade semua operasi entity manager(PERSIST, REMOVE, REFRESH, MERGE, DETACH)


---
## Tutorial 2
### Jawaban Pertanyaan
1. Pada nomor 1 akan terjadi error saat mencoba menambahkan sebuah kebun karena template dari "add-kebun-safari" belum terbuat
2. @Autowired merupakan implementasi dari konsep Depedency Injection. @Autowired mengisi (inject) semua kebutuhan dari class tersebut (dependency).
Dengan adanya anotasi @Autowired, class Controller tidak perlu setter method atau argumen untuk constructor
3. Pada nomor 3 akan terjadi error saat menambahkan sebuah kebun tanpa parameter nomor telepon karena dalam method addKebun seluruh parameter di set required=true.
   Sehingga jika salah satu parameter tidak di-define maka tidak bisa menambah kebun safari yang baru
4. Karena kebun safari dengan nama Papa APAP memiliki id=1. Maka cara aksesnya adalah http://localhost:8080/kebun-safari/?id=1.
   Dengan memanfaatkan method getKebunSafariById
5. Pada localhost:8080 akan menampilkan daftar seluruh kebun safari yang sudah didaftarkan beserta informasi detail mengenai kebun tersebut.
   Berikut link untuk melihat hasil screenshot https://s.id/G6Bph
---
## Tutorial 1
### What I have learned today
Setelah mengerjakan Tutorial 1, saya perlu lebih teliti dalam mengerjakan tutorial selanjutnya dan harus membiasakan diri menggunakan IDE yang baru dan Spring Boot

### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
   Issue Tracker adalah sebuah tab yang berguna untuk melakukan pencatatan terkait ide, umpan balik, dan masalah agar semua hal tersebut dapat didokumentasikan dengan baik
2. Apa perbedaan dari git merge dan git merge --squash?
    Git merge tidak membuat perubahan pada riwayat repositori dan git merge --squash menghasilkan working tree dan status indeks, tetapi merge history dibuang
3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan
   suatu aplikasi? Memungkinkan sebuah tim dapat melakukan analisis, penghapusan, atau perubahan sejak awal proyek dibuat. Sehingga memudahkan untuk terus berada di versi terbaru
### Spring
4. Apa itu library & dependency? Library adalah kumpulan kode yang sudah dibuat yang dapat digunakan pengguna untuk mempermudah dan mengoptimalkan suatu tugas
5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
Maven adalah software project management berdasarkan Project Object Model (POM), Maven dapat mengelola pembuatan, pelaporan, dan dokumentasi dari proyek. Alternatif dari Maven adalah CMake, GNU Make, dan Gradle
6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring
   framework? Mengembangkan aplikasi enterprise-class 
7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
   menggunakan @RequestParam atau @PathVariable? @PathVariable membaca value dari URI path. Sementara @RequestParam di-encoded. @PathVariable digunakan untuk data yang dikirimkan dalam URI Sementara @RequestParam digunakan untuk mengekstrak data yang ditemukan dalam query
