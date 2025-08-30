package uz.bbb.phoneapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PhoneInfo : AppCompatActivity() {
    private val phoneInfo = mapOf(
        "Pixel 10 Pro XL" to """
        📸 Kamera: 50MP + 48MP UltraWide + 48MP Telephoto (5x optik zoom)
        🎥 Video: 8K @30fps, 4K @60fps, HDR10+
        🔋 Bateriya: 5200mAh — 30W zaryad, 23W wireless
        🧠 Chip: Google Tensor G5 — 4nm texnologiya
        📶 Tarmoq: 5G, Wi-Fi 7, UWB, Satellite SOS
        🖥️ Ekran: 6.8" LTPO OLED, 120Hz, 3000 nits
        🛡️ Himoya: Gorilla Glass Victus 2, IP68
        🔌 Zaryad: USB-C 3.2, MagSafe Pixel Stand
        🎨 Ranglar: Obsidian, Porcelain, Rose Quartz, Hazel
        💰 Narxi: $1329 / ₹132,100
    """.trimIndent(),

        "Pixel 10 Pro" to """
        📸 Kamera: 50MP + 48MP UltraWide + 11MP Telephoto
        🎥 Video: 8K @30fps, 4K @60fps, AI Video Boost
        🔋 Bateriya: 5000mAh — 30W zaryad, 21W wireless
        🧠 Chip: Google Tensor G5 — AI optimizatsiya
        📶 Tarmoq: 5G, Wi-Fi 7, NFC, eSIM
        🖥️ Ekran: 6.3" OLED, 120Hz, HDR10+
        🛡️ Himoya: Gorilla Glass Victus 2, IP68
        🔌 Zaryad: USB-C PD3.0, Qi wireless
        🎨 Ranglar: Obsidian, Hazel, Porcelain
        💰 Narxi: $1099 / ₹111,800
    """.trimIndent(),

        "Pixel 10" to """
        📸 Kamera: 50MP + 48MP UltraWide + 11MP Telephoto
        🎥 Video: 4K @60fps, AI Magic Editor
        🔋 Bateriya: 4970mAh — 30W zaryad, 15W wireless
        🧠 Chip: Google Tensor G5 — Android 16 bilan
        📶 Tarmoq: 5G, Wi-Fi 6E, NFC
        🖥️ Ekran: 6.3" OLED, 120Hz
        🛡️ Himoya: Gorilla Glass Victus 2, IP68
        🔌 Zaryad: USB-C, Qi 2 wireless
        🎨 Ranglar: Obsidian, Mint, Rose
        💰 Narxi: $899 / ₹91,450
    """.trimIndent(),

        "Pixel 9 Pro Fold" to """
        📸 Kamera: 50MP + 48MP UltraWide + 48MP Telephoto
        🎥 Video: 8K @30fps, Folded & Unfolded modes
        🔋 Bateriya: 4800mAh — 27W zaryad, 21W wireless
        🧠 Chip: Google Tensor G4 — Fold optimizatsiyasi
        📶 Tarmoq: 5G, Wi-Fi 6E, NFC
        🖥️ Ekran: 8.0" Super Actua Flex + 6.3" OLED
        🛡️ Himoya: IPX8, Gorilla Glass + hinge durability
        🔌 Zaryad: USB-C, wireless reverse
        🎨 Ranglar: Obsidian, Porcelain
        💰 Narxi: $1149 / ₹114,999
    """.trimIndent(),

        "Pixel 9 Pro XL" to """
        📸 Kamera: 50MP + 48MP UltraWide + 48MP Telephoto
        🎥 Video: 8K @30fps, 4K @60fps, HDR10+
        🔋 Bateriya: 5060mAh — 37W zaryad, 23W wireless
        🧠 Chip: Google Tensor G4 — 4nm texnologiya
        📶 Tarmoq: 5G, Wi-Fi 7, UWB
        🖥️ Ekran: 6.8" LTPO OLED, 120Hz, 3000 nits
        🛡️ Himoya: Gorilla Glass Victus 2, IP68
        🔌 Zaryad: USB-C 3.2, Pixel Stand
        🎨 Ranglar: Obsidian, Hazel, Rose Quartz
        💰 Narxi: $989 / ₹99,999
    """.trimIndent(),

        "Pixel 9 Pro" to """
        📸 Kamera: 50MP + 48MP UltraWide + 48MP Telephoto
        🎥 Video: 8K @30fps, AI Zoom Enhance
        🔋 Bateriya: 4700mAh — 27W zaryad, 21W wireless
        🧠 Chip: Google Tensor G4 — Android 14 bilan
        📶 Tarmoq: 5G, Wi-Fi 6E, NFC
        🖥️ Ekran: 6.3" OLED, 120Hz
        🛡️ Himoya: Gorilla Glass Victus 2, IP68
        🔌 Zaryad: USB-C PD3.0
        🎨 Ranglar: Obsidian, Porcelain
        💰 Narxi: $769 / ₹76,999
    """.trimIndent(),

        "Pixel 9" to """
        📸 Kamera: 50MP + 48MP UltraWide
        🎥 Video: 4K @60fps, HDR10+
        🔋 Bateriya: 4700mAh — 27W zaryad, 15W wireless
        🧠 Chip: Google Tensor G4 — 12GB RAM
        📶 Tarmoq: 5G, Wi-Fi 6E, NFC
        🖥️ Ekran: 6.3" OLED, 120Hz
        🛡️ Himoya: Gorilla Glass Victus 2, IP68
        🔌 Zaryad: USB-C, Qi wireless
        🎨 Ranglar: Obsidian, Wintergreen, Peony
        💰 Narxi: $799 / ₹69,999
    """.trimIndent(),

        "Pixel 9a" to """
        📸 Kamera: 48MP + 13MP UltraWide
        🎥 Video: 4K @60fps, AI Magic Eraser
        🔋 Bateriya: 5100mAh — 23W zaryad, 7.5W wireless
        🧠 Chip: Google Tensor G4 — Android 15 bilan
        📶 Tarmoq: 5G, Wi-Fi 6E, NFC
        🖥️ Ekran: 6.3" P-OLED, 120Hz
        🛡️ Himoya: Gorilla Glass 3, IP68
        🔌 Zaryad: USB-C, Qi wireless
        🎨 Ranglar: Obsidian, Iris, Porcelain
        💰 Narxi: $499 / ₹40,080
    """.trimIndent(),

        "Pixel 8 Pro" to """
        📸 Kamera: 50MP + 48MP UltraWide + 48MP Telephoto
        🎥 Video: 4K @60fps, Cinematic Pan
        🔋 Bateriya: 5050mAh — 30W zaryad, 23W wireless
        🧠 Chip: Google Tensor G3 — Titan M2 security
        📶 Tarmoq: 5G, Wi-Fi 6E, NFC
        🖥️ Ekran: 6.7" LTPO OLED, 120Hz, HDR10+
        🛡️ Himoya: Gorilla Glass Victus 2, IP68
        🔌 Zaryad: USB-C, Qi wireless
        🎨 Ranglar: Obsidian, Porcelain, Mint
        💰 Narxi: $600 / ₹47,999
    """.trimIndent(),

        "Pixel 8" to """
    📸 Kamera: 50MP + 12MP UltraWide
    🎥 Video: 4K @60fps, Motion Mode, Real Tone HDR
    🔋 Bateriya: 4575mAh — 27W zaryad, 18W wireless
    🧠 Chip: Google Tensor G3 — Android 14 bilan, Titan M2 xavfsizlik
    📶 Tarmoq: 5G, Wi-Fi 6E, Bluetooth 5.3, NFC
    🖥️ Ekran: 6.2" Actua OLED, 120Hz, HDR10+
    🛡️ Himoya: Gorilla Glass Victus 2, IP68 suv va changga chidamli
    🔌 Zaryad: USB-C PD3.0, Qi wireless
    🎨 Ranglar: Obsidian, Rose, Mint
    💰 Narxi: $699 / ₹58,999
""".trimIndent(),

        "iPhone 16 Pro Max" to """
        📸 Kamera: 48MP Wide + 48MP UltraWide + 12MP Telephoto (5x zoom)
        🎥 Video: 4K Dolby Vision @120fps, Spatial Video
        🔋 Bateriya: 4685mAh — 25W zaryad, 15W wireless
        🧠 Chip: Apple A18 Pro — 3nm, 8GB RAM
        🖥️ Ekran: 6.9" Super Retina XDR OLED, 120Hz
        🛡️ Himoya: Ceramic Shield, IP68
        🔌 Port: USB-C 3.2 Gen 2
        🎨 Ranglar: Black, White, Natural, Desert Titanium
        💰 Narxi: $1,599 / ₹132,900
    """.trimIndent(),

        "iPhone 16 Pro" to """
        📸 Kamera: 48MP Wide + 48MP UltraWide + 12MP Telephoto (5x zoom)
        🎥 Video: 4K Dolby Vision @120fps, ProRes
        🔋 Bateriya: 3582mAh — 25W zaryad, 15W wireless
        🧠 Chip: Apple A18 Pro — 3nm, 8GB RAM
        🖥️ Ekran: 6.3" OLED, 120Hz, Always-On
        🛡️ Himoya: Ceramic Shield, IP68
        🔌 Port: USB-C 3.2 Gen 2
        🎨 Ranglar: Black, White, Natural, Desert Titanium
        💰 Narxi: $1,299 / ₹110,900
    """.trimIndent(),

        "iPhone 16" to """
        📸 Kamera: 48MP Wide + 12MP UltraWide
        🎥 Video: 4K Dolby Vision @60fps, Cinematic Mode
        🔋 Bateriya: 3561mAh — 25W zaryad, 15W wireless
        🧠 Chip: Apple A18 — 3nm, 8GB RAM
        🖥️ Ekran: 6.1" OLED, 60Hz
        🛡️ Himoya: Ceramic Shield, IP68
        🔌 Port: USB-C
        🎨 Ranglar: Black, White, Pink, Teal, Ultramarine
        💰 Narxi: $799 / ₹79,900
    """.trimIndent(),

        "iPhone 15 Pro Max" to """
        📸 Kamera: 48MP Wide + 12MP UltraWide + 12MP Telephoto (5x zoom)
        🎥 Video: 4K Dolby Vision @60fps, ProRes
        🔋 Bateriya: 4441mAh — 27W zaryad, 15W wireless
        🧠 Chip: Apple A17 Pro — 3nm, 8GB RAM
        🖥️ Ekran: 6.7" OLED, 120Hz
        🛡️ Himoya: Ceramic Shield, IP68
        🔌 Port: USB-C
        🎨 Ranglar: Black, Blue, White, Natural Titanium
        💰 Narxi: $1,399 / ₹119,900
    """.trimIndent(),

        "iPhone 15 Pro" to """
        📸 Kamera: 48MP Wide + 12MP UltraWide + 12MP Telephoto (3x zoom)
        🎥 Video: 4K Dolby Vision @60fps, Cinematic Mode
        🔋 Bateriya: 3650mAh — 27W zaryad, 15W wireless
        🧠 Chip: Apple A17 Pro — 3nm, 8GB RAM
        🖥️ Ekran: 6.1" OLED, 120Hz
        🛡️ Himoya: Ceramic Shield, IP68
        🔌 Port: USB-C
        🎨 Ranglar: Black, Blue, White, Natural Titanium
        💰 Narxi: $1,099 / ₹99,900
    """.trimIndent(),

        "iPhone 15" to """
        📸 Kamera: 48MP Wide + 12MP UltraWide
        🎥 Video: 4K Dolby Vision @60fps
        🔋 Bateriya: 3349mAh — 20W zaryad, 15W wireless
        🧠 Chip: Apple A16 Bionic — 5nm, 6GB RAM
        🖥️ Ekran: 6.1" OLED, 60Hz
        🛡️ Himoya: Ceramic Shield, IP68
        🔌 Port: USB-C
        🎨 Ranglar: Black, Blue, Green, Yellow, Pink
        💰 Narxi: $799 / ₹79,900
    """.trimIndent(),

        "iPhone 14 Pro Max" to """
        📸 Kamera: 48MP Wide + 12MP UltraWide + 12MP Telephoto (3x zoom)
        🎥 Video: 4K Dolby Vision @60fps
        🔋 Bateriya: 4323mAh — 20W zaryad, 15W wireless
        🧠 Chip: Apple A16 Bionic — 5nm, 6GB RAM
        🖥️ Ekran: 6.7" OLED, 120Hz
        🛡️ Himoya: Ceramic Shield, IP68
        🔌 Port: Lightning
        🎨 Ranglar: Space Black, Silver, Gold, Deep Purple
        💰 Narxi: $1,099 / ₹109,900
    """.trimIndent(),

        "iPhone 14 Pro" to """
        📸 Kamera: 48MP Wide + 12MP UltraWide + 12MP Telephoto (3x zoom)
        🎥 Video: 4K Dolby Vision @60fps
        🔋 Bateriya: 3200mAh — 20W zaryad, 15W wireless
        🧠 Chip: Apple A16 Bionic — 5nm, 6GB RAM
        🖥️ Ekran: 6.1" OLED, 120Hz
        🛡️ Himoya: Ceramic Shield, IP68
        🔌 Port: Lightning
        🎨 Ranglar: Space Black, Silver, Gold, Deep Purple
        💰 Narxi: $999 / ₹99,900
    """.trimIndent(),

        "iPhone 14" to """
        📸 Kamera: 12MP Wide + 12MP UltraWide
        🎥 Video: 4K Dolby Vision @60fps
        🔋 Bateriya: 3279mAh — 20W zaryad, 15W wireless
        🧠 Chip: Apple A15 Bionic — 5nm, 6GB RAM
        🖥️ Ekran: 6.1" OLED, 60Hz
        🛡️ Himoya: Ceramic Shield, IP68
        🔌 Port: Lightning
        🎨 Ranglar: Blue, Purple, Midnight, Starlight, Product(RED)
        💰 Narxi: $799 / ₹79,900
    """.trimIndent(),

        "iPhone 13 Pro Max" to """
        📸 Kamera: 12MP Wide + 12MP UltraWide + 12MP Telephoto (3x zoom)
        🎥 Video: 4K Dolby Vision @60fps
        🔋 Bateriya: 4352mAh — 20W zaryad, 15W wireless
        🧠 Chip: Apple A15 Bionic — 5nm, 6GB RAM
        🖥️ Ekran: 6.7" OLED, 120Hz
        🛡️ Himoya: Ceramic Shield, IP68
        🔌 Port: Lightning
        🎨 Ranglar: Graphite, Gold, Silver, Sierra Blue
        💰 Narxi: $999 / ₹99,900
    """.trimIndent(),
        "iPhone 13 Pro" to """
    📸 Kamera: 12MP Wide + 12MP UltraWide + 12MP Telephoto (3x zoom) + LiDAR
    🎥 Video: 4K Dolby Vision @60fps, ProRes, Night Mode Time-lapse
    🔋 Bateriya: 3095mAh — 20W zaryad, 15W MagSafe wireless
    🧠 Chip: Apple A15 Bionic — 5nm, 6GB RAM
    🖥️ Ekran: 6.1" Super Retina XDR OLED, 120Hz ProMotion
    🛡️ Himoya: Ceramic Shield, IP68 suv va changga chidamli
    🔌 Port: Lightning (USB 2.0)
    🎨 Ranglar: Graphite, Gold, Silver, Sierra Blue, Alpine Green
    💰 Narxi: $581 / ₹48,500 (128GB) — $1,720 / ₹143,800 (512GB)
""".trimIndent(),
        "iPhone 13" to """
    📸 Kamera: 12MP Wide + 12MP UltraWide
    🎥 Video: 4K Dolby Vision @60fps, Cinematic Mode
    🔋 Bateriya: 3240mAh — 20W zaryad, 15W MagSafe wireless
    🧠 Chip: Apple A15 Bionic — 5nm, 4GB RAM
    🖥️ Ekran: 6.1" Super Retina XDR OLED, 60Hz
    🛡️ Himoya: Ceramic Shield, IP68 suv va changga chidamli
    🔌 Port: Lightning (USB 2.0)
    🎨 Ranglar: Starlight, Midnight, Blue, Pink, Green, Product(RED)
    💰 Narxi: $386 / ₹43,900 (128GB) — ₹74,999 (512GB)
""".trimIndent(),
        "Galaxy S23 Ultra" to """
        📸 Kamera: 200MP Wide + 12MP UltraWide + 10MP Telephoto (3x) + 10MP Periscope (10x)
        🎥 Video: 8K @30fps, 4K HDR10+, Expert RAW
        🔋 Bateriya: 5000mAh — 45W zaryad, 15W wireless
        🧠 Chip: Snapdragon 8 Gen 2 for Galaxy — 4nm
        🖥️ Ekran: 6.8" QHD+ AMOLED, 120Hz, Vision Booster
        🛡️ Himoya: Gorilla Glass Victus 2, IP68
        🔌 Port: USB-C 3.2 Gen 2
        🎨 Ranglar: Phantom Black, Green, Cream, Lavender
        💰 Narxi: $1,199 / ₹124,999
    """.trimIndent(),

        "Galaxy S22" to """
        📸 Kamera: 50MP Wide + 12MP UltraWide + 10MP Telephoto (3x)
        🎥 Video: 8K @24fps, Super Steady
        🔋 Bateriya: 3700mAh — 25W zaryad, 15W wireless
        🧠 Chip: Snapdragon 8 Gen 1 — 4nm
        🖥️ Ekran: 6.1" FHD+ AMOLED, 120Hz
        🛡️ Himoya: Gorilla Glass Victus+, IP68
        🔌 Port: USB-C
        🎨 Ranglar: Phantom Black, White, Green, Pink Gold
        💰 Narxi: $699 / ₹58,999
    """.trimIndent(),

        "Galaxy S21 Ultra" to """
        📸 Kamera: 108MP Wide + 12MP UltraWide + 10MP Telephoto (3x) + 10MP Periscope (10x)
        🎥 Video: 8K @24fps, Director’s View
        🔋 Bateriya: 5000mAh — 25W zaryad, 15W wireless
        🧠 Chip: Exynos 2100 / Snapdragon 888 — 5nm
        🖥️ Ekran: 6.8" WQHD+ AMOLED, 120Hz
        🛡️ Himoya: Gorilla Glass Victus, IP68
        🔌 Port: USB-C
        🎨 Ranglar: Phantom Silver, Phantom Black
        💰 Narxi: $899 / ₹84,999
    """.trimIndent(),

        "Galaxy S21" to """
        📸 Kamera: 12MP Wide + 12MP UltraWide + 64MP Telephoto
        🎥 Video: 8K @24fps, Single Take
        🔋 Bateriya: 4000mAh — 25W zaryad, 15W wireless
        🧠 Chip: Exynos 2100 / Snapdragon 888 — 5nm
        🖥️ Ekran: 6.2" FHD+ AMOLED, 120Hz
        🛡️ Himoya: Gorilla Glass Victus, IP68
        🔌 Port: USB-C
        🎨 Ranglar: Phantom Gray, Phantom Violet, Phantom White
        💰 Narxi: $599 / ₹49,999
    """.trimIndent(),

        "Galaxy S20 Ultra" to """
        📸 Kamera: 108MP Wide + 12MP UltraWide + 48MP Periscope (10x)
        🎥 Video: 8K @24fps, Super Zoom
        🔋 Bateriya: 5000mAh — 45W zaryad, 15W wireless
        🧠 Chip: Exynos 990 / Snapdragon 865 — 7nm+
        🖥️ Ekran: 6.9" QHD+ AMOLED, 120Hz
        🛡️ Himoya: Gorilla Glass 6, IP68
        🔌 Port: USB-C
        🎨 Ranglar: Cosmic Gray, Cosmic Black
        💰 Narxi: $499 / ₹42,999 (refurbished)
    """.trimIndent(),

        "Galaxy S20" to """
        📸 Kamera: 12MP Wide + 12MP UltraWide + 64MP Telephoto
        🎥 Video: 8K @24fps, HDR10+
        🔋 Bateriya: 4000mAh — 25W zaryad, 15W wireless
        🧠 Chip: Exynos 990 / Snapdragon 865 — 7nm+
        🖥️ Ekran: 6.2" QHD+ AMOLED, 120Hz
        🛡️ Himoya: Gorilla Glass 6, IP68
        🔌 Port: USB-C
        🎨 Ranglar: Cloud Blue, Cloud Pink, Cosmic Gray
        💰 Narxi: $186 / ₹33,999
    """.trimIndent(),

        "Galaxy Note 20" to """
        📸 Kamera: 12MP Wide + 12MP UltraWide + 64MP Telephoto
        🎥 Video: 8K @24fps, S-Pen Air Actions
        🔋 Bateriya: 4300mAh — 25W zaryad, 15W wireless
        🧠 Chip: Exynos 990 / Snapdragon 865+ — 7nm+
        🖥️ Ekran: 6.7" FHD+ AMOLED, 60Hz
        🛡️ Himoya: Gorilla Glass 5, IP68
        🔌 Port: USB-C
        🎨 Ranglar: Mystic Bronze, Mystic Green, Mystic Gray
        💰 Narxi: $296 / ₹86,000
    """.trimIndent(),

        "Galaxy Note 10" to """
        📸 Kamera: 12MP Wide + 16MP UltraWide + 12MP Telephoto
        🎥 Video: 4K @60fps, Live Focus Video
        🔋 Bateriya: 3500mAh — 25W zaryad, 12W wireless
        🧠 Chip: Exynos 9825 / Snapdragon 855 — 7nm
        🖥️ Ekran: 6.3" FHD+ AMOLED, HDR10+
        🛡️ Himoya: Gorilla Glass 6, IP68
        🔌 Port: USB-C
        🎨 Ranglar: Aura Black, Aura Glow, Aura Red
        💰 Narxi: $119 / ₹39,999
    """.trimIndent(),

        "Galaxy S10 Plus" to """
        📸 Kamera: 12MP Wide + 12MP Telephoto + 16MP UltraWide
        🎥 Video: 4K @60fps, Super Steady
        🔋 Bateriya: 4100mAh — 15W zaryad, 15W wireless
        🧠 Chip: Exynos 9820 / Snapdragon 855 — 8nm
        🖥️ Ekran: 6.4" QHD+ AMOLED, HDR10+
        🛡️ Himoya: Gorilla Glass 6, IP68
        🔌 Port: USB-C
        🎨 Ranglar: Prism White, Ceramic Black, Prism Green
        💰 Narxi: $231 / ₹32,000
    """.trimIndent(),

        "Galaxy S10" to """
        📸 Kamera: 12MP Wide + 12MP Telephoto + 16MP UltraWide
        🎥 Video: 4K @60fps, HDR10+
        🔋 Bateriya: 3400mAh — 15W zaryad, 15W wireless
        🧠 Chip: Exynos 9820 / Snapdragon 855 — 8nm
        🖥️ Ekran: 6.1" QHD+ AMOLED, HDR10+
        🛡️ Himoya: Gorilla Glass 6, IP68
        🔌 Port: USB-C
        🎨 Ranglar: Prism White, Prism Black, Prism Blue
        💰 Narxi: $211 / ₹24,999
    """.trimIndent(),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_phone_info)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val model = intent.getStringExtra("model")?.trim() ?: "Unknown"
        val info = phoneInfo[model] ?: "Ma'lumot topilmadi"

        val bannerText = findViewById<TextView>(R.id.brandName)
        bannerText.text = model

        val textView = findViewById<TextView>(R.id.tvPhoneDetails)
        textView.text = info
    }
}