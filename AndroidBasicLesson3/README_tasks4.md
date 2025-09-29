# Android Layouts – Module 3, Lesson 4

📌 Ushbu loyihada Android `FrameLayout` va `RelativeLayout` bilan ishlash mashqlari bajarildi.  
Bir nechta rangli `View` lar `FrameLayout` ichida joylashtirilib, `layout_margin` orqali kichraytirib ustma-ust joylash effekti qilindi.

---


---

## 📂 Kod namunasi
```xml
<FrameLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/red">

    <View
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_margin="25dp"
        android:background="#A867B6"/>

    <View
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_margin="50dp"
        android:background="#8CD900"/>

    <View
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_margin="75dp"
        android:background="#47C9FF"/>
</FrameLayout>