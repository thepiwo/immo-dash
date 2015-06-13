-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 13, 2015 at 08:30 PM
-- Server version: 5.5.43
-- PHP Version: 5.4.40-1+deb.sury.org~precise+4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hackday`
--

-- --------------------------------------------------------

--
-- Table structure for table `preisindex_vdp`
--

CREATE TABLE IF NOT EXISTS `preisindex_vdp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jahr` int(11) DEFAULT NULL,
  `quartal` int(11) DEFAULT NULL,
  `value` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=50 ;

--
-- Dumping data for table `preisindex_vdp`
--

INSERT INTO `preisindex_vdp` (`id`, `jahr`, `quartal`, `value`) VALUES
(1, 2003, 1, 100.5),
(2, 2003, 2, 99.8),
(3, 2003, 3, 99.8),
(4, 2003, 4, 99.8),
(5, 2004, 1, 99.8),
(6, 2004, 2, 100.2),
(7, 2004, 3, 100.2),
(8, 2004, 4, 99.7),
(9, 2005, 1, 101.5),
(10, 2005, 2, 100.4),
(11, 2005, 3, 101.6),
(12, 2005, 4, 101.4),
(13, 2006, 1, 100.5),
(14, 2006, 2, 101.5),
(15, 2006, 3, 101.2),
(16, 2006, 4, 101.8),
(17, 2007, 1, 102.4),
(18, 2007, 2, 102.5),
(19, 2007, 3, 102.6),
(20, 2007, 4, 103.9),
(21, 2008, 1, 104.7),
(22, 2008, 2, 104.7),
(23, 2008, 3, 104.8),
(24, 2008, 4, 104.8),
(25, 2009, 1, 104.1),
(26, 2009, 2, 103.9),
(27, 2009, 3, 104),
(28, 2009, 4, 104.1),
(29, 2010, 1, 103.8),
(30, 2010, 2, 104.2),
(31, 2010, 3, 104.8),
(32, 2010, 4, 105.4),
(33, 2011, 1, 105.8),
(34, 2011, 2, 106.4),
(35, 2011, 3, 108.7),
(36, 2011, 4, 109.2),
(37, 2012, 1, 110.4),
(38, 2012, 2, 111),
(39, 2012, 3, 111.8),
(40, 2012, 4, 113.6),
(41, 2013, 1, 114.3),
(42, 2013, 2, 115.6),
(43, 2013, 3, 117.3),
(44, 2013, 4, 117.5),
(45, 2014, 1, 119.1),
(46, 2014, 2, 121.1),
(47, 2014, 3, 123.4),
(48, 2014, 4, 124.3),
(49, 2015, 1, 126.1),
(50, 2015, 2, 127.4);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
