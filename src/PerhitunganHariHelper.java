
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;
import java.time.temporal.ChronoUnit;

public class PerhitunganHariHelper {
    // Menghitung jumlah hari + hari pertama & terakhir + status kabisat
    public static String hitungJumlahHari(int bulan, int tahun) {
        YearMonth ym = YearMonth.of(tahun, bulan);
        int jumlahHari = ym.lengthOfMonth();

        LocalDate tanggalAwal = LocalDate.of(tahun, bulan, 1);
        LocalDate tanggalAkhir = LocalDate.of(tahun, bulan, jumlahHari);

        String namaBulan = tanggalAwal.getMonth()
                .getDisplayName(TextStyle.FULL, new Locale("id", "ID"));
        String hariPertama = tanggalAwal.getDayOfWeek()
                .getDisplayName(TextStyle.FULL, new Locale("id", "ID"));
        String hariTerakhir = tanggalAkhir.getDayOfWeek()
                .getDisplayName(TextStyle.FULL, new Locale("id", "ID"));

        boolean kabisat = Year.isLeap(tahun);
        String infoKabisat = kabisat ? "Tahun ini adalah tahun kabisat." : "Tahun ini bukan tahun kabisat.";

        return String.format(
            "<html><b>%s %d</b><br>"
            + "Jumlah Hari: %d<br>"
            + "Hari Pertama: %s<br>"
            + "Hari Terakhir: %s<br>"
            + "<i>%s</i></html>",
            namaBulan, tahun, jumlahHari, hariPertama, hariTerakhir, infoKabisat
        );
    }

    // Menghitung selisih hari antara dua tanggal
    public static long hitungSelisih(LocalDate tgl1, LocalDate tgl2) {
        return Math.abs(ChronoUnit.DAYS.between(tgl1, tgl2));
    }
}
