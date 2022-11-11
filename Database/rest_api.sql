-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 01, 2021 at 01:28 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rest_api`
--

-- --------------------------------------------------------

--
-- Table structure for table `funding_management`
--

CREATE TABLE `funding_management` (
  `fund_id` int(11) NOT NULL,
  `funding_provider_name` varchar(45) DEFAULT NULL,
  `contact_no` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `funding_management`
--

INSERT INTO `funding_management` (`fund_id`, `funding_provider_name`, `contact_no`, `email`, `amount`, `address`) VALUES
(2, 'Gayan Kavinda', '0702131350', 'gayan982822513.lk@gmail.com', 450000, '42/15/c1,Luvisawatta, Yakkala2'),
(4, 'sdadc5568', '0764264296', 'ad@gmail.com', 230000, '5641 AV. UK'),
(10, 'Machan1', '0115599665', 'abcd@yahoo.com', 150000, 'Koswatta'),
(11, 'Mahasona', '956156', 'Kanatta@gmail.com', 999999, 'Sohona Road, Kanatta'),
(12, 'sliit', '561', 'afasafa', 135000, 'malabe'),
(13, 'BuddimalP', 'buddimal@gmail.com', 'hkjh', 1000, 'jjjjjjjjjjjjjjj'),
(14, 'Vimala2', '222222', 'sdgfsgs', 156, 'ssdgdgsg');

-- --------------------------------------------------------

--
-- Table structure for table `order_management`
--

CREATE TABLE `order_management` (
  `order_id` int(11) NOT NULL,
  `product_name` varchar(45) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `customer_name` varchar(45) DEFAULT NULL,
  `customer_address` varchar(45) DEFAULT NULL,
  `contact_no` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order_management`
--

INSERT INTO `order_management` (`order_id`, `product_name`, `quantity`, `customer_name`, `customer_address`, `contact_no`) VALUES
(2, 'chair', 10, 'gayan', 'yakkala', '1111111'),
(3, 'books', 5, 'minosh', 'chilow', '22222'),
(5, 'apple iphone', 100, 'Nimesha', 'yakkala', '85661654'),
(6, 'pen drive 8gb', 5000, 'Sadun', 'Minuwangoda', '48964156489'),
(10, 'laptop', 6516161, 'mcn', 'asfasfaf', '000000000000');

-- --------------------------------------------------------

--
-- Table structure for table `payment_management`
--

CREATE TABLE `payment_management` (
  `payment_id` int(11) NOT NULL,
  `name_on_card` varchar(45) DEFAULT NULL,
  `card_number` varchar(45) DEFAULT NULL,
  `cvv` varchar(45) DEFAULT NULL,
  `exp_day` varchar(45) DEFAULT NULL,
  `amout` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment_management`
--

INSERT INTO `payment_management` (`payment_id`, `name_on_card`, `card_number`, `cvv`, `exp_day`, `amout`) VALUES
(1, 'Mahasona', '956156', '1554', '26', 45000),
(4, 'sadun', '9545', '9951', '31', 90000),
(15, 'Boralugoda', '8888', '999', '99/06/2021', 26000),
(16, 'Galpatha', '99999', '888', '88/06/2021', 45000),
(18, NULL, NULL, NULL, NULL, NULL),
(19, NULL, NULL, NULL, NULL, NULL),
(20, 'ythc', '161', '615', '15', 15616),
(21, 'BOC', '1784653544353', '907', '2023/12/12', 89000),
(22, 'Selan', '1784600000', '907', '2023/12/12', 89000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `funding_management`
--
ALTER TABLE `funding_management`
  ADD PRIMARY KEY (`fund_id`);

--
-- Indexes for table `order_management`
--
ALTER TABLE `order_management`
  ADD PRIMARY KEY (`order_id`);

--
-- Indexes for table `payment_management`
--
ALTER TABLE `payment_management`
  ADD PRIMARY KEY (`payment_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `funding_management`
--
ALTER TABLE `funding_management`
  MODIFY `fund_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `order_management`
--
ALTER TABLE `order_management`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `payment_management`
--
ALTER TABLE `payment_management`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
