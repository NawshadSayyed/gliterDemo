-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 22, 2019 at 05:04 AM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `gliterdb`
--
CREATE DATABASE IF NOT EXISTS `gliterdb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `gliterdb`;

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `GetAllProducts`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllProducts`()
BEGIN
SELECT sr.*,sm.maths,sm.sci,sm.history,sm.english FROM student_registraion sr left join student_mark sm on sr.stu_id = sm.stu_id;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `getstudentinfo`
--
DROP VIEW IF EXISTS `getstudentinfo`;
CREATE TABLE IF NOT EXISTS `getstudentinfo` (
`stu_id` int(11)
,`stu_name` varchar(300)
,`stu_address` text
,`stu_standerd` text
,`stu_start_session` date
,`stu_end_session` date
,`maths` int(11)
,`sci` int(11)
,`history` int(11)
,`english` int(11)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `getstudentresult`
--
DROP VIEW IF EXISTS `getstudentresult`;
CREATE TABLE IF NOT EXISTS `getstudentresult` (
`stu_id` int(11)
,`stu_name` varchar(300)
,`stu_address` text
,`stu_standerd` text
,`stu_start_session` date
,`stu_end_session` date
,`maths` int(11)
,`sci` int(11)
,`history` int(11)
,`english` int(11)
,`total` bigint(14)
,`result` varchar(4)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `get_total`
--
DROP VIEW IF EXISTS `get_total`;
CREATE TABLE IF NOT EXISTS `get_total` (
`totlPass` bigint(21)
,`total_fail` bigint(21)
);
-- --------------------------------------------------------

--
-- Table structure for table `student_mark`
--

DROP TABLE IF EXISTS `student_mark`;
CREATE TABLE IF NOT EXISTS `student_mark` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL,
  `maths` int(11) NOT NULL,
  `sci` int(11) NOT NULL,
  `history` int(11) NOT NULL,
  `english` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `student_mark`
--

INSERT INTO `student_mark` (`id`, `stu_id`, `maths`, `sci`, `history`, `english`) VALUES
(1, 1, 50, 60, 80, 40),
(2, 2, 40, 35, 90, 69),
(3, 3, 60, 60, 70, 45),
(4, 4, 55, 53, 78, 49),
(5, 5, 46, 20, 35, 29),
(6, 6, 35, 34, 35, 35),
(7, 7, 10, 15, 25, 45),
(8, 8, 25, 28, 45, 41),
(9, 9, 35, 40, 80, 40),
(10, 10, 46, 65, 74, 44);

-- --------------------------------------------------------

--
-- Table structure for table `student_registraion`
--

DROP TABLE IF EXISTS `student_registraion`;
CREATE TABLE IF NOT EXISTS `student_registraion` (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(300) DEFAULT NULL,
  `stu_address` text NOT NULL,
  `stu_standerd` text,
  `stu_start_session` date NOT NULL,
  `stu_end_session` date NOT NULL,
  PRIMARY KEY (`stu_id`),
  UNIQUE KEY `stu_name` (`stu_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `student_registraion`
--

INSERT INTO `student_registraion` (`stu_id`, `stu_name`, `stu_address`, `stu_standerd`, `stu_start_session`, `stu_end_session`) VALUES
(1, 'sam', 'uk', '10', '2019-04-01', '2020-03-31'),
(2, 'ram', 'india', '10', '2019-04-01', '2020-03-31'),
(3, 'radha', 'india', '10', '2019-04-01', '2020-03-31'),
(4, 'sumit', 'india', '10', '2019-04-01', '2020-03-31'),
(5, 'nick', 'us', '10', '2019-04-01', '2020-03-31'),
(6, 'sultan', 'india', '10', '2019-04-01', '2020-03-31'),
(7, 'jhon', 'london', '10', '2019-04-01', '2020-03-31'),
(8, 'Riya', 'uk', '10', '2019-04-01', '2020-03-31'),
(9, 'Samira', 'uk', '10', '2019-04-01', '2020-03-31'),
(10, 'Dipika', 'uk', '10', '2019-04-01', '2020-03-31');

-- --------------------------------------------------------

--
-- Table structure for table `student_result`
--

DROP TABLE IF EXISTS `student_result`;
CREATE TABLE IF NOT EXISTS `student_result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL,
  `result` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure for view `getstudentinfo`
--
DROP TABLE IF EXISTS `getstudentinfo`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `getstudentinfo` AS select `sr`.`stu_id` AS `stu_id`,`sr`.`stu_name` AS `stu_name`,`sr`.`stu_address` AS `stu_address`,`sr`.`stu_standerd` AS `stu_standerd`,`sr`.`stu_start_session` AS `stu_start_session`,`sr`.`stu_end_session` AS `stu_end_session`,`sm`.`maths` AS `maths`,`sm`.`sci` AS `sci`,`sm`.`history` AS `history`,`sm`.`english` AS `english` from (`student_registraion` `sr` left join `student_mark` `sm` on((`sr`.`stu_id` = `sm`.`stu_id`)));

-- --------------------------------------------------------

--
-- Structure for view `getstudentresult`
--
DROP TABLE IF EXISTS `getstudentresult`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `getstudentresult` AS select `getstudentinfo`.`stu_id` AS `stu_id`,`getstudentinfo`.`stu_name` AS `stu_name`,`getstudentinfo`.`stu_address` AS `stu_address`,`getstudentinfo`.`stu_standerd` AS `stu_standerd`,`getstudentinfo`.`stu_start_session` AS `stu_start_session`,`getstudentinfo`.`stu_end_session` AS `stu_end_session`,`getstudentinfo`.`maths` AS `maths`,`getstudentinfo`.`sci` AS `sci`,`getstudentinfo`.`history` AS `history`,`getstudentinfo`.`english` AS `english`,(((`getstudentinfo`.`maths` + `getstudentinfo`.`sci`) + `getstudentinfo`.`history`) + `getstudentinfo`.`english`) AS `total`,if((((((`getstudentinfo`.`maths` + `getstudentinfo`.`sci`) + `getstudentinfo`.`history`) + `getstudentinfo`.`english`) / 4) > 45),'pass','fail') AS `result` from `getstudentinfo` order by `getstudentinfo`.`stu_id`;

-- --------------------------------------------------------

--
-- Structure for view `get_total`
--
DROP TABLE IF EXISTS `get_total`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `get_total` AS select (select count(`gs`.`result`) from `getstudentresult` `gs` where (`gs`.`result` = 'pass')) AS `totlPass`,(select count(`gs`.`result`) from `getstudentresult` `gs` where (`gs`.`result` = 'fail')) AS `total_fail` from `getstudentresult` `gss` where (`gss`.`result` = 'pass') group by `gss`.`result`;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
