import java.util.Scanner;

public class MahasiswaDemo3 {
    public static void main(String[] args) {
        
        MahasiswaBerprestasi3 list = new MahasiswaBerprestasi3();
        
        Scanner sc = new Scanner(System.in);

        int jumMhs = 5;

        // System.out.print("Masukkan jumlah mahasiswa: ");
        // int jumMhs = sc.nextInt();
        // sc.nextLine(); 

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
