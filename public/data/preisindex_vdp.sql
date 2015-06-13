-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 13, 2015 at 07:50 PM
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
  `jahr` int(4) NOT NULL,
  `quartal` int(1) NOT NULL,
  `value` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='vpd Preisindex aus CVS';

--
-- Dumping data for table `preisindex_vdp`
--

INSERT INTO `preisindex_vdp` (`jahr`, `quartal`, `value`) VALUES
(2003, 1, 100),
(2003, 2, 99),
(2003, 3, 99),
(2003, 4, 99),
(2004, 1, 99),
(2004, 2, 100),
(2004, 3, 100),
(2004, 4, 99),
(2005, 1, 101),
(2005, 2, 100),
(2005, 3, 101),
(2005, 4, 101),
(2006, 1, 100),
(2006, 2, 101),
(2006, 3, 101),
(2006, 4, 101),
(2007, 1, 102),
(2007, 2, 102),
(2007, 3, 102),
(2007, 4, 103),
(2008, 1, 104),
(2008, 2, 104),
(2008, 3, 104),
(2008, 4, 104),
(2009, 1, 104),
(2009, 2, 103),
(2009, 3, 104),
(2009, 4, 104),
(2010, 1, 103),
(2010, 2, 104),
(2010, 3, 104),
(2010, 4, 105),
(2011, 1, 105),
(2011, 2, 106),
(2011, 3, 108),
(2011, 4, 109),
(2012, 1, 110),
(2012, 2, 111),
(2012, 3, 111),
(2012, 4, 113),
(2013, 1, 114),
(2013, 2, 115),
(2013, 3, 117),
(2013, 4, 117),
(2014, 1, 119),
(2014, 2, 121),
(2014, 3, 123),
(2014, 4, 124),
(2015, 1, 126);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
