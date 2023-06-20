-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 20, 2023 at 01:40 PM
-- Server version: 8.0.31
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `altp`
--

-- --------------------------------------------------------

--
-- Table structure for table `cau_hoi`
--

DROP TABLE IF EXISTS `cau_hoi`;
CREATE TABLE IF NOT EXISTS `cau_hoi` (
  `noi_dung` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `dapan_a` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `dapan_b` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `dapan_c` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `dapan_d` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `dapan` varchar(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `linh_vuc` int NOT NULL,
  `muc_do` int NOT NULL,
  `xoa` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`noi_dung`),
  KEY `fk_cauhoi_linhvuc_idx` (`linh_vuc`),
  KEY `fk_cauhoi_mucdo_idx` (`muc_do`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Dumping data for table `cau_hoi`
--

INSERT INTO `cau_hoi` (`noi_dung`, `dapan_a`, `dapan_b`, `dapan_c`, `dapan_d`, `dapan`, `linh_vuc`, `muc_do`, `xoa`) VALUES
('\"Bu\" là gì?', 'Bà', 'Mẹ', 'Ông', 'Cha', 'B', 9, 1, 0),
('\"El Nino\" là gì?', 'Một vũ công chuyên nghiệp', 'Một khu rừng ở châu phi', 'Một điệu nhảy', 'Một hiện tượng thời tiết', 'D', 9, 1, 0),
('\"Trở về Eden\" là tiểu thuyết của tác giả nào?', 'Margaret Atwood', 'Steve Jobs', 'Rosalind Miles', 'Tim Cook', 'C', 3, 3, 0),
('1 + 1 = ?', '0', '2', '69', '10', '2', 1, 1, 0),
('1 x 0 = ??', '1', '0', '4', '3', 'B', 1, 1, 1),
('2 + 2 = ?', '0', '2', '3', '4', '4', 1, 1, 0),
('Ai là vị vua cuối cùng của triều đại nhà Mạc?', 'Mạc Văn Khoa', 'Mạc Đĩnh Chi', 'Mạc Từ Tốn', 'Mạc Toàn', 'D', 13, 3, 0),
('Bảy chú lùn trong \"Bạch Tuyết và bảy chú lùn\" làm nghề gì?', 'Thợ rèn', 'Thợ may', 'Thợ săn', 'Thợ mỏ', 'D', 3, 2, 0),
('Biểu tượng của thành phố Vác-xa-va, thủ đô Ba Lan là biểu tượng mang hình gì?', 'Một vị thánh', 'Một chú sư tử', 'Một nàng tiên', 'Một nàng tiên cá', 'D', 9, 3, 0),
('Hang động lớn nhất thế giới nằm ở đâu?', 'Malaysia', 'Chile', 'Việt Nam', 'Nam Phi', 'C', 9, 2, 0),
('Làng cổ Phước Tích ở Huế có nghề truyền thống gì?', 'Làm áo dài', 'Làm gốm', 'Làm tranh thờ cúng', 'Làm nước mắm', 'B', 9, 3, 0),
('Màu nào sau đây không có trên lá cờ Olympic', 'Đen', 'Tím', 'Đỏ', 'Xanh dương', 'B', 9, 2, 0),
('Người ta thường nấu canh cua với thứ gì?', 'Củ cải', 'Rau đay', 'Mộc nhĩ', 'Quả óc chó', 'B', 8, 2, 0),
('Quần đảo Nam Du thuộc tỉnh nào nước ta?', 'Cà Mau', 'Kiên Giang', 'Bạc Liêu', 'Trà Vinh', 'B', 12, 2, 0),
('Sông Trà Khúc nằm ở tỉnh nào?', 'Quảng Ngãi', 'Thanh Hoá', 'Quảng Bình', 'Nghệ An', 'A', 12, 3, 0),
('Tác phẩm \"Đời thừa\" của Nam Cao lần đầu tiên được đăng trên báo nào?', 'Tiểu thuyết thứ bảy', 'Ngày nay', 'Phụ nữ tân văn', 'Tiểu thuyết tình yêu', 'A', 9, 3, 0),
('Theo dân gian, sông Hương có mùi thơm là do loài cây nào mọc ở hai bên bờ?', 'Thạch xương bồ', 'Bồ công anh', 'Thạch thảo', 'Dạ hương', 'A', 9, 3, 0),
('Theo một câu hát \"Ba thương con vì con giống mẹ, mẹ thương con vì con giống ...\" ai?', 'Ông hàng xóm', 'Chú cạnh nhà', 'Ba', 'Bác đầu ngõ', 'C', 11, 1, 0),
('Thương cảng Vân Đồn cổ xưa của nước Đại Việt được thành lập dưới thời vị vua nào?', 'Lý Thánh Tông', 'Lý Nhân Tông', 'Lý Anh Tông', 'Lý Cao Tông', 'C', 13, 3, 0),
('Trong bàn cờ tướng có bao nhiêu quân Mã?', '1', '2', '3', '4', 'B', 9, 1, 0),
('Trong hệ nhị phân, 1 + 1 = ?', '2', '0', '1010', '10', 'D', 10, 1, 0),
('Đất nước nào nằm ở Châu Âu?', 'Trung Quốc', 'Đông Timo', 'Ai Cập', 'Pháp', 'D', 12, 2, 0),
('Đâu là loại cháo khác với các món còn lại?', 'Cháo bò', 'Cháo gà', 'Cháo heo', 'Cháo vịt', 'C', 9, 2, 0),
('Đâu là một sáng tác của Sơn Tùng M-TP', 'Nơi này có chị', 'Nơi này có anh', 'Nơi này có chú', 'Nơi này có cha', 'B', 11, 1, 0),
('Đâu là một tác phẩm Opera của nhà soạn kịch người Nga Pyotr Ilyich Tchaikovsky', 'Hồ Thiên Nga', 'Cô gái Orleans', 'Người đẹp ngủ trong rừng', 'Romeo và Juliet', 'B', 3, 3, 0),
('Đâu là tên một loại mũ?', 'Lưỡi hái', 'Lưỡi lê', 'Lưỡi trai', 'Lưỡi bò', 'C', 9, 2, 0),
('Đâu là tên một truyện cổ tích?', 'Công chúa ngủ trong rừng', 'Công chúa ngủ trong tủ', 'Công chúa ngủ trên giường', 'Công chúa bị mất ngủ', 'A', 3, 1, 0),
('Điền vào chỗ trống trong câu sau: \"Gieo gió gặt ...\"', 'Lũ', 'Mưa', 'Giông', 'Bão', 'D', 9, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `linh_vuc`
--

DROP TABLE IF EXISTS `linh_vuc`;
CREATE TABLE IF NOT EXISTS `linh_vuc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Dumping data for table `linh_vuc`
--

INSERT INTO `linh_vuc` (`id`, `name`) VALUES
(1, 'Toán học'),
(2, 'Sinh học'),
(3, 'Văn học'),
(4, 'Khoa học'),
(5, 'Hoá học'),
(6, 'Ngoại ngữ'),
(8, 'Java'),
(9, 'Đời sống'),
(10, 'Tin học'),
(11, 'Âm nhạc'),
(12, 'Địa lý'),
(13, 'Lịch sử'),
(14, 'Python');

-- --------------------------------------------------------

--
-- Table structure for table `muc_do`
--

DROP TABLE IF EXISTS `muc_do`;
CREATE TABLE IF NOT EXISTS `muc_do` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Dumping data for table `muc_do`
--

INSERT INTO `muc_do` (`id`, `name`) VALUES
(1, 'Dễ'),
(2, 'Trung bình'),
(3, 'Khó');

-- --------------------------------------------------------

--
-- Table structure for table `nguoi_dung`
--

DROP TABLE IF EXISTS `nguoi_dung`;
CREATE TABLE IF NOT EXISTS `nguoi_dung` (
  `tai_khoan` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `mat_khau` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `ho_ten` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `gioi_tinh` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `nam_sinh` int NOT NULL,
  `que_quan` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`tai_khoan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Dumping data for table `nguoi_dung`
--

INSERT INTO `nguoi_dung` (`tai_khoan`, `mat_khau`, `ho_ten`, `gioi_tinh`, `nam_sinh`, `que_quan`) VALUES
('admin', '123456', 'Bảo Lê', 'Nam', 1997, 'Hồ Chí Minh'),
('ngoc', '123', 'Ngọc', 'nu', 1990, 'hcm'),
('nguyen', '123', 'Nguyên', 'nam', 1997, 'hcm'),
('user1', '123456', 'User Một', 'Nam', 1996, 'Hà Nội');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cau_hoi`
--
ALTER TABLE `cau_hoi`
  ADD CONSTRAINT `fk_cauhoi_linhvuc` FOREIGN KEY (`linh_vuc`) REFERENCES `linh_vuc` (`id`),
  ADD CONSTRAINT `fk_cauhoi_mucdo` FOREIGN KEY (`muc_do`) REFERENCES `muc_do` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
