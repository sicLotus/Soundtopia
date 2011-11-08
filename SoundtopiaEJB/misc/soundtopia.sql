-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 08. November 2011 um 14:50
-- Server Version: 5.1.41
-- PHP-Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `soundtopia`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Daten für Tabelle `admin`
--


-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `charts`
--

CREATE TABLE IF NOT EXISTS `charts` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `lastUpdated` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Daten für Tabelle `charts`
--


-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `lyric`
--

CREATE TABLE IF NOT EXISTS `lyric` (
  `id` int(11) NOT NULL,
  `text` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `lyric`
--


-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `rating`
--

CREATE TABLE IF NOT EXISTS `rating` (
  `userID` int(11) NOT NULL,
  `songID` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  PRIMARY KEY (`userID`,`songID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Daten für Tabelle `rating`
--


-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `song`
--

CREATE TABLE IF NOT EXISTS `song` (
  `id` int(11) NOT NULL,
  `interpreter` varchar(255) CHARACTER SET latin1 NOT NULL,
  `title` varchar(255) CHARACTER SET latin1 NOT NULL,
  `date` date NOT NULL,
  `tracklength` int(11) NOT NULL,
  `video` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `rating` float DEFAULT '0',
  `voteCount` int(11) NOT NULL DEFAULT '0',
  `voteTotal` int(11) NOT NULL DEFAULT '0',
  `picture` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `priceAmazon` float DEFAULT NULL,
  `priceItunes` float DEFAULT NULL,
  `price7digital` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Daten für Tabelle `song`
--


-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `song_in_chart`
--

CREATE TABLE IF NOT EXISTS `song_in_chart` (
  `songID` int(11) NOT NULL,
  `chartID` int(11) NOT NULL,
  `ranking` int(11) NOT NULL,
  `added` date NOT NULL,
  PRIMARY KEY (`songID`,`chartID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Daten für Tabelle `song_in_chart`
--


-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Daten für Tabelle `user`
--


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
