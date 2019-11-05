-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Mar 05 Novembre 2019 à 15:44
-- Version du serveur :  10.3.17-MariaDB-0+deb10u1
-- Version de PHP :  7.3.11-1+0~20191026.48+debian9~1.gbpf71ca0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `escalade`
--

--
-- Contenu de la table `commentaire`
--

INSERT INTO `commentaire` (`id`, `comm`, `user_auteur`, `site`) VALUES
(12, 'TEST 2', 41, 3),
(15, 'TEST', 41, 7),
(17, 'TEST DE COM', 41, 3),
(18, 'AZERTY', 41, 3),
(39, 'modération', 41, 1);

--
-- Contenu de la table `cotation`
--

INSERT INTO `cotation` (`id`, `cot`) VALUES
(1, '2'),
(2, '2a'),
(3, '2a+'),
(4, '2b'),
(5, '2b+'),
(6, '2c'),
(7, '2c+'),
(8, '3'),
(9, '3a'),
(10, '3a+'),
(11, '3b'),
(12, '3b+'),
(13, '3c'),
(14, '3c+'),
(15, '4'),
(16, '4a'),
(17, '4a+'),
(18, '4b'),
(19, '4b+'),
(20, '4c'),
(21, '4c+'),
(22, '5'),
(23, '5a'),
(24, '5a+'),
(25, '5b'),
(26, '5b+'),
(27, '5c'),
(28, '5c+'),
(29, '6'),
(30, '6a'),
(31, '6a+'),
(32, '6b'),
(33, '6b+'),
(34, '6c'),
(35, '6c+'),
(36, '7'),
(37, '7a'),
(38, '7a+'),
(39, '7b'),
(40, '7b+'),
(41, '7c'),
(42, '7c+'),
(43, '8'),
(44, '8a'),
(45, '8a+'),
(46, '8b'),
(47, '8b+'),
(48, '8c'),
(49, '8c+'),
(50, '9'),
(51, '9a'),
(52, '9a+'),
(53, '9b'),
(54, '9b+'),
(55, '9c');

--
-- Contenu de la table `lieu`
--

INSERT INTO `lieu` (`id`, `name`) VALUES
(22, 'Ardèche'),
(2, 'La Réunion'),
(23, 'Paris');

--
-- Contenu de la table `reservation`
--

INSERT INTO `reservation` (`id`, `topo`, `user`, `processed`) VALUES
(6, 40, 47, 1),
(8, 40, 47, 1),
(9, 40, 47, 0),
(10, 42, 47, 0);

--
-- Contenu de la table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'registered'),
(2, 'admin');

--
-- Contenu de la table `site`
--

INSERT INTO `site` (`id`, `nom`, `lieu`, `cotation`, `nbre_secteur`, `officiel`) VALUES
(1, 'Site ardéchois', 22, 43, 2, 0),
(3, 'site réunionais', 2, 1, 1, 0),
(7, 'Ardéchois dfficile', 22, 35, 3, 0),
(8, 'paris', 23, 14, 5, 1);

--
-- Contenu de la table `topo`
--

INSERT INTO `topo` (`id`, `name`, `description`, `lieu`, `date_parution`, `disponible`, `user`) VALUES
(40, 'pk_bug', 'New Topo sur la réunion. C&#39;est vachement bien! Sisi', 2, '2019-10-23', 1, 41),
(42, 'réunion', 'testestestest', 2, '2019-10-23', 1, 41),
(44, 'topodeRégis!', 'Le Super topo de Régis!', 2, '2019-10-24', 1, 47),
(46, 'topo paris', 'new topo', 23, '2019-10-30', 1, 47);

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id`, `loginn`, `pswd`, `pseudo`, `role`) VALUES
(41, 'delarosa.jonathan@free.fr', '$2a$10$tPLZyUcPerdkFvCejhSn4uiHtud8VjgOyJ5KSzAvpLWuBL9iyH/02', 'RCarter', 2),
(43, 'rca.iron@hotmail.fr', '$2a$10$ryMyuqewH3x/TrfbQPkobuKFYxJ.rO7.uVfm.95aqA61YE4o7dEg2', 'Sothoth/', 1),
(47, 'test@test.fr', '$2a$10$dauSo.f/X6RQMCEo/FQMpeoNJO6wOMRB8URfQ4HGYMCzcn0QoSO4G', 'Rgéis_92-', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
