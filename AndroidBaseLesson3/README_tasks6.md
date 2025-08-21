# Android GridLayout UI

📱 Ushbu loyiha **Android GridLayout** yordamida UI elementlarini joylashtirishni amaliy ko‘rsatib beradi.  
Misolda 3 ta ustun va 5 ta qatordan iborat layout ishlatilgan. Ayrim `FrameLayout` lar `rowSpan` va `columnSpan` yordamida kengaytirilgan.

## 📂 Strukturasi
- `GridLayout` → Asosiy container (`rowCount=5`, `columnCount=3`)
- `FrameLayout` → Ichida `View` elementlari joylashtirilgan
- `layout_rowSpan` va `layout_columnSpan` → elementlarni kengaytirib joylashtirish uchun

## 🖼️ UI namunasi
- 1-qatorda chapda bitta kvadrat, o‘ng tomonda 2 ustunni egallagan to‘rtburchak.
- 2 va 3 qatorlarda elementlar joylashgan, lekin o‘ng ustun 2 qator bo‘yi cho‘zilgan.
- 4-qator esa yana oddiy 2 ta element bilan tugaydi.

## 🚀 Ishga tushirish
1. Android Studio da yangi loyiha oching
2. `activity_main.xml` faylini shu kod bilan almashtiring
3. Emulatorda ishga tushiring

---

### 📚 O‘rgatilgan mavzular
- `GridLayout`
- `FrameLayout`
- `rowSpan`, `columnSpan`
- Margin va ichki `View`