# **TreeMLBBTutorial**

## Overview
Di project ini, saya menerapkan struktur data Tree menggunakan Java untuk memetakan urutan beli item di Mobile Legends (MLBB). Bedanya dengan daftar biasa, di sini urutan item dibuat seperti pohon bercabang untuk menggambarkan pilihan item yang bisa berubah sesuai situasi pertandingan. Jadi, setiap jalur dari akar (root) sampai ke ujung (leaf) adalah satu kombinasi build item yang utuh.

# Features
- Tree Representation: Merepresentasikan item MLBB sebagai node dalam struktur pohon untuk menggambarkan alur pembelian.
- Recursive Tree Printing: Menampilkan struktur hierarki tree secara visual menggunakan teknik rekursi agar mudah dipahami.
- Root-to-Leaf Path Tracing: Mencetak semua jalur build lengkap dari awal hingga item terakhir.
- Tree Statistics: Menghitung total nodes, jumlah leaf nodes (titik akhir build), dan height (tinggi) dari pohon tersebut.
- Path Searching: Mencari dan menunjukkan urutan pembelian yang mengarah ke satu item tertentu.

## Example Output
=== TREE STRUCTURE ===

- Start Build -> Choose your first major purchase path
  
- Windtalker -> Fast farming / tempo path
        - Berserker's Fury -> Higher burst follow-up
                - Malefic Roar -> Break tougher enemies later
                        - Blade of Despair -> Maximize late damage
                        - Immortality -> Final safety item
                - Wind of Nature -> Defensive option versus physical danger

- Haas' Claws -> Lifesteal sustain option
        - Corrosion Scythe -> Slow and chase potential
                - Immortality -> Final safety item

- Demon Hunter Sword -> Tank-busting path
        - Golden Staff -> Attack speed cap synergy
                - Corrosion Scythe -> Slow effect for kiting
                        - Blade of Despair -> Maximum damage output
        - Windtalker -> Alternative attack speed option
        
- Endless Battle -> Spell vamp / true damage path
        - Thunder Belt -> Defensive hybrid option
                - Brute Force Breastplate -> Movement speed stacking
        - Queen's Wings -> Damage reduction when low HP


## How to Run
1. Clone repo ini:
   ```bash
   git clone https://github.com/username/TreeMLBBTutorial.git
2. Compile program:
   ```bash
   avac TreeMLBBTutorial.java

3. Jalankan:
   ```bash
   java TreeMLBBTutorial

## Observation Questions
- Root Node: Node pertama atau titik awal dalam program ini adalah Start Build, yang menjadi fondasi bagi seluruh jalur pembelian item.
- Leaf Nodes: Merupakan item terakhir dalam sebuah rangkaian build yang tidak memiliki children lagi. Berdasarkan output, contohnya adalah Blade of Despair, Immortality, Wind of Nature, Brute Force Breastplate, dan Queen's Wings.
- List<ItemNode> for Children: Penggunaan List bertujuan agar satu item dapat memiliki lebih dari satu pilihan item berikutnya (percabangan). Jika hanya menggunakan variabel tunggal, struktur data akan menjadi linear dan tidak bisa menggambarkan pilihan strategi yang beragam.
- Linear vs Tree Structure: Perbedaan utamanya terletak pada fleksibilitas. Linear structure hanya menyediakan satu jalur tetap (seperti array), sedangkan tree structure memungkinkan adanya percabangan keputusan di mana satu titik awal bisa menghasilkan banyak kombinasi akhir yang berbeda.
- Recursion in Trees: Rekursi sangat membantu dalam proses traversal (penelusuran) karena struktur pohon memiliki pola berulang. Setiap node diperlakukan sebagai "akar" bagi sub-pohon di bawahnya, sehingga kode yang sama dapat digunakan untuk memproses seluruh tingkatan pohon secara otomatis.
- Search Path for Corrosion Scythe: Berdasarkan hasil eksekusi program, jalur menuju item tersebut adalah:

Start Build -> Windtalker -> Haas' Claws -> Corrosion Scythe.

## Reflection
- Why Tree is Better than Array: Struktur tree jauh lebih cocok untuk merepresentasikan pembelian item karena dalam gameplay nyata, pemain sering kali harus beradaptasi. Sebuah array hanya bisa menyimpan satu urutan kaku, sementara tree mampu memetakan seluruh kemungkinan skenario atau strategi lawan dalam satu model yang terorganisir.

- Understanding Recursion: Melalui lab ini, saya lebih memahami bagaimana rekursi bekerja dengan cara memecah masalah besar (menelusuri seluruh pohon) menjadi tugas-tugas kecil yang identik pada setiap node. Tantangan terbesarnya adalah memastikan base case yang tepat agar program tidak berjalan tanpa henti dan memahami bagaimana program kembali ke atas (backtracking) setelah mencapai leaf node.
