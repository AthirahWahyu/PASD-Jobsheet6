# JOBSHEET 6

# PRAKTIKUM 

## - Praktikum 1 : Searching/Pencarian Menggunakan Algoritma Sequential Search

## - Praktikum 1 : Verifikasi Hasil Percobaan

![Verifikasi1](./Verifikasi1.png)

![Verifikasi2](./Verifikasi2.png)

_Pertanyaan:_

1.  Jelaskan perbedaan metod tampilDataSearch dan tampilPosisi pada class MahasiswaBerprestasi!
2.  Jelaskan fungsi break pada kode program di bawah ini!

    ```java
        if (listMhs[j].ipk == cari) {
                    posisi = j;
                    break;
    ``` 
3. Apa fungsi variabel pos atau indeks hasil pencarian dalam program sequential search?
4.  Jika terdapat lebih dari satu data dengan nilai yang sama, hasil pencarian sequential search yang dibuat di atas akan menampilkan data ke berapa? Jelaskan.
5.  Berkaitan dengan pertanyaan nomor 2 di atas, apa yang terjadi jika perintah break dihapus dari kode di atas?

_Jawaban:_ 

1.  - tampilPosisi ➝ fokus pada letak data (indeks)
    - tampilDataSearch ➝ fokus pada isi/detail data mahasiswa
2.  Fungsi break pada potongan kode tersebut adalah untuk menghentikan perulangan (loop) secara langsung saat data yang dicari sudah ditemukan.
3.  Fungsi variabel pos atau indeks hasil pencarian dalam program sequential search adalah untuk menyimpan lokasi (index) dari data yang ditemukan di dalam array.
4.  Pada kode sequential search yang sudah dibuat, jika terdapat lebih dari satu data dengan nilai IPK yang sama, maka yang akan ditampilkan adalah: data pertama yang ditemukan (indeks paling kecil/paling awal di array)
5.  - Dengan break ➝ ambil data pertama yang ditemukan 
    - Tanpa break ➝ ambil data terakhir yang ditemukan 
    - Tanpa break juga membuat proses lebih lama (kurang efisien)

## - Praktikum 2 : Searching/Pencarian Menggunakan Algoritma Binary Search

## - Praktikum 2 : Verifikasi Hasil Percobaan

![Verifikasi1](./Verifikasi3.png)

![Verifikasi2](./Verifikasi4.png)

![Verifikasi2](./Verifikasi5.png)

_Pertanyaan:_

1. Tunjukkan pada kode program yang mana proses divide dijalankan!
2.  Tunjukkan pada kode program yang mana proses conquer dijalankan!
3.  Apa fungsi left, right, dan mid?
4. Jika data IPK yang dimasukkan tidak urut. Apakah program masih dapat berjalan? Mengapa demikian? 
5.  Jika IPK yang dimasukkan dari IPK terbesar ke terkecil (misal: 3.8, 3.7, 3.5, 3.4, 3.2) dan elemen yang dicari adalah 3.2. Bagaimana hasil dari Binary Search? Apakah sesuai? Jika tidak sesuai maka ubahlah kode program Binary Search agar hasilnya sesuai 
6.  Jelaskan bagaimana Binary Search menentukan bahwa data yang dicari tidak ditemukan di dalam array.
7.  Modifikasi program di atas yang mana jumlah mahasiswa yang diinputkan sesuai dengan masukan dari keyboard.

_Jawaban:_

1.  - Pada algoritma Binary Search, konsep Divide and Conquer terdiri dari 3 tahap : 
        - Divide : Membagi data menjadi 2 bagian 
        - Conquer : Memilih salah satu bagian 
        - Combine : Hail dikembalikan

    Proses divide pada binary search terdapat pada : 
    ```java 
        mid = (left+right) / 2;
    ```
    Karena di sinilah data dibagi menjadi dua bagian sebelum dipilih bagian mana yang akan dicari.
2.  Pada algoritma Binary Search (Divide and Conquer), bagian conquer adalah saat program memproses sub-masalah (bagian array yang sudah dibagi) dengan cara memilih salah satu sisi (kiri atau kanan) untuk dicari lebih lanjut.

    - Proses conquer terdapat pada baris rekursif : 
    ```java 
        return findBinarySearch(cari, left, mid-1); // ke kiri
    ```

    ```java 
        return findBinarySearch(cari, mid+1, right); // ke kanan
    ```

3.  - left : batas awal pencarian 
    - right : batas akhir pencarian 
    - mid : titik tengah untuk dibandingkan 
4.  Program tetap dapat berjalan meskipun data IPK tidak urut, tetpi hasilnya hanya akurat jika menggunakan sequential search, sedangkan binary search memerlukan data yang sudah terurut agar dapat bekerja dengan benar.
5.  Binary Search harus menyesuaikan dengan urutan data. Jika diurutkan secara menurun (DESC), maka kondisi perbandingan dalam kode harus dibalik agar hasil pencarian tetap akurat.

Code pada class MahasiswaBerprestasi3 :

```java
    int findBinarySearch(double cari, int left, int right){
        int mid;
        if (right>=left) {
            mid = (left+right)/2;
            if (cari == listMhs[mid].ipk) {
                return mid;
            } else if (listMhs[mid].ipk < cari){
                return findBinarySearch(cari, left, mid-1);
            } else {
                return findBinarySearch(cari, mid+1, right);
            }
        }
        return -1;
    }
```
6.  Binary Search menyatakan data tidak ditemukan ketika batas pencarian sudah habis (right < left), sehingga fungsi mengembalikan nilai -1 sebagai tanda bahwa data tidak ada di dalam array.
7.  Code pada class MahasiswaBerprestasi3 : 
    ```java 
        public class MahasiswaBerprestasi3 {
        Mahasiswa3 [] listMhs = new Mahasiswa3 [5];
        int idx;

        // constructor untuk menentukan ukuran array 
        MahasiswaBerprestasi3(int jumlah){
            listMhs = new Mahasiswa3[jumlah];
        }
        
        void tambah (Mahasiswa3 m){
            if (idx < listMhs.length) {
                listMhs[idx] = m;
                idx++;
            }else{
                System.out.println("data sudah penuh");
            }
        }

        void tampil () {
            for (Mahasiswa3 m : listMhs){
                if (m!=null) {
                    
                    m.tampilInformasi();
                    System.out.println("-----------------------");
                }
                }
        }

        void bubbleSort() {
            for (int i = 0; i < listMhs.length-1; i++) {
                for (int j = 1; j < listMhs.length-i; j++) {
                    if (listMhs[j] != null)
                    if (listMhs[j].ipk > listMhs[j-1].ipk) {
                        Mahasiswa3 tmp = listMhs[j];
                        listMhs[j] = listMhs[j-1];
                        listMhs[j-1] = tmp;
                    }
                }
            }
        }

        void selectionSort(){
            for (int i = 0; i < listMhs.length-1; i++) {
                int idxMin = i;
                for (int j = i+1; j < listMhs.length; j++) {
                    if (listMhs[j].ipk < listMhs[idxMin].ipk) {
                        idxMin = j;  
                    }
                }
                Mahasiswa3 tmp = listMhs[idxMin];
                listMhs[idxMin] = listMhs[i];
                listMhs[i] = tmp; 
            }
        }

        void insertionSort(){
            for (int i = 1; i < listMhs.length; i++) {
                Mahasiswa3 temp = listMhs[i];
                int j = i;
                while (j > 0 && listMhs[j-1].ipk < temp.ipk) {
                    listMhs[j] = listMhs[j-1];
                    j--;
                }
                listMhs[j] = temp;
            }
        }

        int sequentialSearching(double cari){
            int posisi = -1;
            for (int j = 0; j < listMhs.length; j++) {
                if (listMhs[j].ipk == cari) {
                    posisi = j;
                    break;
                }
            }
            return posisi;
        }

        int findBinarySearch(double cari, int left, int right){
            int mid;
            if (right>=left) {
                mid = (left+right)/2;
                if (cari == listMhs[mid].ipk) {
                    return mid;
                } else if (listMhs[mid].ipk < cari){
                    return findBinarySearch(cari, left, mid-1);
                } else {
                    return findBinarySearch(cari, mid+1, right);
                }
            }
            return -1;
        }

        void tampilPosisi(double x, int pos) {
            if (pos!= -1) {
                System.out.println("data mahasiswa dengan IPK :" + x + " ditemukan pada indeks " + pos);
            } else {
                System.out.println("data " +x+ "tidak ditemukan");
            }
        }

        void tampilDataSearch(double x, int pos){
            if (pos !=-1) {
                System.out.println("nim\t : "+listMhs[pos].nim);
                System.out.println("nama\t : "+listMhs[pos].nama);
                System.out.println("kelas\t : "+listMhs[pos].kelas);
                System.out.println("ipk\t : "+x);
            }else{
                System.out.println("Data mahasiswa dengan IPK " +x+ " tidak ditemukan");
            }
        }
    }
```

    Code pada class MahasiswaDemo3 : 

    ```java
        import java.util.Scanner;

        public class MahasiswaDemo3 {
            public static void main(String[] args) {
                
                
                Scanner sc = new Scanner(System.in);
                
                System.out.print("Masukkan jumlah mahasiswa: ");
                int jumMhs = sc.nextInt();
                sc.nextLine();
                
                MahasiswaBerprestasi3 list = new MahasiswaBerprestasi3(jumMhs);

                for (int i = 0; i < jumMhs; i++) {
                    System.out.println("\nData Mahasiswa ke-" + (i+1));

                    System.out.print("NIM   : ");
                    String nim = sc.nextLine();

                    System.out.print("Nama  : ");
                    String nama = sc.nextLine();

                    System.out.print("Kelas : ");
                    String kelas = sc.nextLine();

                    System.out.print("IPK   : ");
                    double ipk = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("--------------------------------");
                    list.tambah (new Mahasiswa3(nim, nama, kelas, ipk));

                    // Mahasiswa3 m = new Mahasiswa3(nim, nama, kelas, ipk);
                    // list.tambah(m);
                }

                System.out.println("Data mahasiswa sebelum sorting: ");
                list.tampil();

                // System.out.println("\nData Mahasiswa setelah sorting berdasarkan IPK (DESC) : ");
                // list.bubbleSort();
                // list.tampil();

                // System.out.println("Data yang sudah terurut menggunakan SELECTION SORT (ASC)");
                // list.selectionSort();
                // list.tampil();

                // System.out.println("Data yang sudah terurut menggunakan INSERTION SORT (ASC)");
                // list.insertionSort();
                // list.tampil();

                // melakukan pencarian data sequential 
                System.out.println("-----------------------------------");
                System.out.println("Pencarian data");
                System.out.println("-----------------------------------");
                System.out.println("Masukkan IPK mahasiswa yang dicari: ");
                System.out.print("IPK: ");
                double cari = sc.nextDouble();

                System.out.println("-----------------------------------");
                System.out.println("Menggunakan Binary Search");
                System.out.println("-----------------------------------");
                double posisi2 = list.findBinarySearch(cari, 0, jumMhs-1);
                int pss2 = (int) posisi2;
                list.tampilPosisi(cari, pss2);
                list.tampilDataSearch(posisi2, pss2);

                // System.out.println("Menggunakan sequential searching");
                // double posisi = list.sequentialSearching(cari);
                // int pss = (int)posisi;
                // list.tampilPosisi(cari, pss);
                // list.tampilDataSearch(cari, pss);
            }
        }
```



