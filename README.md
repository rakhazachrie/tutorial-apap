# Tutorial APAP

## Authors

* **Muhammad Rakha Zachrie** - *1906353795* - *A*

---
## Tutorial 7
### Jawaban Pertanyaan
1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot
sebagai ilustrasi dari apa yang Anda jelaskan.  
> Nomor 1 -> Pada remove item, melakukan fungsi yang sebaliknya dari add item dan mengatur list removeItems agar saat penghapusan item menjadi sesuai  
Nomor 2 -> Mengatur balance pada saat melakukan add dan remove item. Pada saat add item, maka newBalance = balance - price. Pada saat remove item, maka newBalance = balance + price  
Nomor 3 -> Membuat if-else apabila balance < 0 maka akan menampilkan alert dan barang tidak bisa ditambahkan ke keranjang
2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan
props?  
> State dan props melakukan fungsi yang sama tetapi digunakan dengan cara yang berbeda. Props digunakan untuk pass data dari
parent ke child atau dari komponen itu sendiri dan immutable. State digunakan untuk data yang mutable atau data yang akan berubah
3. Menurut kamu, apakah sebaiknya kita menggunakan component (e.g. List, Item) dalam
React? sebutkan alasannya.  
> Karena component merupakan elemen React yang independen dan reusable. Component bekerja seperti JS function dan mengembalikan HTML
4. Apa perbedaan class component dan functional component?  
> Class component secara sederhana adalah class yang dibentuk dari berbagai function. Functional component adalah JavaScript functions. Class component mengharuskan extend dari React, harus menggunakan method render() untuk mengembalikan html, dan membutuhkan contructor untuk dapat men-store state
5. Dalam react, apakah perbedaan component dan element?  
> Element adalah objek sederhana yang mendeskripsikan atributnya dan objek yang immutable. Component adalah function atau class yang menerima input dan mengembalikan react element. Menyimpan reference ke DOM nodes dan instance dari child component
---

## Tutorial 6
### Jawaban Pertanyaan
1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode
   yang telah anda buat) konsep tersebut diimplementasi?  
Otentikasi adalah proses memverifikasi siapa seseorang, sedangkan Otorisasi adalah proses memverifikasi
aplikasi, file, dan data spesifik apa yang dapat diakses pengguna. Otentikasi adalah implementasi dari login.
Sementara otorisasi adalah implementasi dari soal latihan nomor 1 - 3.  
2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.  
BCryptPasswordEncoder adalah implementasi PasswordEncoder yang menggunakan fungsi hashing kuat BCrypt.
Cara kerjanya adalah encode raw password. Generally, a good encoding algorithm applies a SHA-1 or greater hash 
combined with an 8-byte or greater randomly generated salt.  
3. Apakah penyimpanan password sebaiknya menggunakan encryption atau hashing? Mengapa
   demikian?  
Penyimpanan password sebaiknya menggunakan hashing. Hashing cocok untuk validasi password karena 'one-way' function. 
Mustahil untuk decrypt hash dan mendapatkan plain password.  
4. Jelaskan secara singkat apa itu UUID beserta penggunaannya!  
   UUID adalah Universally unique identifier, yang dapat membantu mendapatkan unique id secara universal.
5. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut  
   Class UserDetailsServiceImpl.java digunakan untuk melakukan retrieving data user dari database yang kita miliki, 
yang kemudian digunakan untuk proses otentikasi.

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


## Tutorial 4
### Jawaban Pertanyaan
1. Jelaskan perbedaan th:include dan th:replace!  
th:include -- menyisipkan fragment yang ditentukan sebagai body dari host tag termasuk fragment tag.  
th:replace -- menggantikan host tag dengan fragment. Sehingga menghapus host tag dan menggantikannya 
dengan fragment yang sudah ditentukan.  
2. Jelaskan apa fungsi dari th:object!  
th:object berfungsi untuk menginisiasi objek agar data tersebut bisa diterima Spring.  
3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?  
'$' merupakan variable expression yang digunakan untuk menginisiasi variable yang dikirimkan controller.  
'*' merupakan selection expression yang digunakan untuk mengambil data yang di-declare sebelumnya.
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
