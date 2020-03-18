<?php

include("config.php");

$nama = $_POST['nama'];
$nim = $_POST['nim'];
$alamat = $_POST['alamat'];

$sql = "INSERT INTO data_mahasiswa VALUES ( NULL,'$nama' , '$nim', '$alamat' )";
$query = mysqli_query($db , $sql);

// apakah query update berhasil ?
if ($query) {
  // code...
} else {
  // kalau gagal tampilkan pesan
  die("Gagal menyimpan perubahan");
}
