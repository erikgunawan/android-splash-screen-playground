# android-splash-screen-playground

Demo app pola **System SplashScreen API** + **CampaignStartup** untuk Android.

Referensi:
- [Splash screens](https://developer.android.com/develop/ui/views/launch/splash-screen)
- [App startup time](https://developer.android.com/topic/performance/vitals/launch-time)
- [Migrate your splash screen implementation](https://developer.android.com/develop/ui/views/launch/migrate-splash-screen)
- [App startup best practices](https://developer.android.com/topic/performance/vitals/launch-time#best-practices)

Detail desain & rencana implementasi: lihat riwayat PR per fase.

## Mengukur startup performance (TTID/TTFD)

- **TTID (Time To Initial Display)**: waktu sampai frame pertama tampil (system splash icon).
- **TTFD (Time To Full Display)**: waktu sampai app benar-benar siap dipakai — di app ini ditandai dengan `reportFullyDrawn()` yang dipanggil saat `CampaignStartup` selesai (timer habis atau user tap skip).

Cara baca dari logcat:

```
adb logcat -s ActivityTaskManager:I
```

Cari baris `Displayed` (TTID) dan `Fully drawn` (TTFD) untuk `id.erikgunawan.splashscreenplayground/.MainActivity`. Selisih keduanya kira-kira sama dengan durasi `CampaignStartup` (default 3 detik) — ini trade-off yang harus disadari kalau campaign dibuat lebih lama.

Log tambahan `StartupPerf` (lihat `adb logcat -s StartupPerf:D`) menandai kapan CampaignStartup mulai dan selesai.
