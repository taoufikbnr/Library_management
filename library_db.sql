-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 21 nov. 2024 à 11:07
-- Version du serveur : 8.0.31
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `library`
--

-- --------------------------------------------------------

--
-- Structure de la table `authors`
--

DROP TABLE IF EXISTS `authors`;
CREATE TABLE IF NOT EXISTS `authors` (
  `code_auteur` int NOT NULL AUTO_INCREMENT,
  `nom_auteur` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prenom_auteur` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`code_auteur`),
  UNIQUE KEY `code_auteur` (`code_auteur`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `authors`
--

INSERT INTO `authors` (`code_auteur`, `nom_auteur`, `prenom_auteur`, `created_at`, `updated_at`) VALUES
(1, 'Joanne', 'Rowling', '2024-11-12 08:17:17', '2024-11-12 08:17:17'),
(2, 'Ben', 'taw', '2024-11-12 09:39:01', '2024-11-12 12:19:57'),
(3, 'Jon', 'wick', '2024-11-12 12:44:40', '2024-11-12 12:44:40'),
(4, 'R. R. Martin ', 'George', '2024-11-16 09:43:45', '2024-11-16 09:43:45'),
(5, 'Henri', 'Charrière', '2024-11-16 18:34:13', '2024-11-16 18:36:01');

-- --------------------------------------------------------

--
-- Structure de la table `date`
--

DROP TABLE IF EXISTS `date`;
CREATE TABLE IF NOT EXISTS `date` (
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `date`
--

INSERT INTO `date` (`date`) VALUES
('2024-11-08'),
('2024-11-08'),
('2024-11-13'),
('2024-11-13'),
('2024-11-08'),
('2024-11-08');

-- --------------------------------------------------------

--
-- Structure de la table `documents`
--

DROP TABLE IF EXISTS `documents`;
CREATE TABLE IF NOT EXISTS `documents` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cote` int NOT NULL,
  `titre` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `theme` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date_parution` date NOT NULL,
  `etat` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'disponible',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'disponible',
  `ISBN` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `diplome` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `editeur` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `cote` (`cote`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `documents`
--

INSERT INTO `documents` (`id`, `cote`, `titre`, `theme`, `date_parution`, `etat`, `type`, `ISBN`, `diplome`, `editeur`, `created_at`, `updated_at`) VALUES
(1, 1, 'ISET', 'mecanique', '2019-10-11', 'disponible', 'memoire', NULL, 'Doctorat', NULL, '2024-11-04 13:45:08', '2024-11-17 19:28:02'),
(6, 4, 'titre', 'test', '2021-11-04', 'non disponible', 'ouvrage', '3', NULL, 'Wicken', '2024-11-07 13:40:56', '2024-11-16 09:36:16'),
(10, 9, 'Fantastic Beasts', 'sc-fi', '2024-11-13', 'disponible', 'memoire', NULL, 'Doctorat', NULL, '2024-11-12 10:55:19', '2024-11-16 09:36:27'),
(11, 10, 'harry potter ', 'sc-fi', '2024-11-13', 'disponible', 'ouvrage', '‎978-0590353427', '', 'JK', '2024-11-12 10:55:53', '2024-11-16 09:36:29'),
(12, 3, 'Game of Thrones', 'fantasy', '1996-11-03', 'disponible', 'ouvrage', '9780553103540', NULL, 'Katherine Chappell ', '2024-11-16 09:51:40', '2024-11-16 19:08:31'),
(13, 12, 'Papillon', 'Autobiographical novel', '1969-04-30', 'disponible', 'ouvrage', '0-06-093479-4', NULL, 'Henri Charrière', '2024-11-16 18:57:08', '2024-11-16 19:08:54'),
(14, 44, 'test', 'test', '2024-11-02', 'non disponible', 'memoire', NULL, 'Licence', NULL, '2024-11-16 19:11:35', '2024-11-16 19:11:35'),
(15, 55, 'Project manager', 'mecanique', '2018-11-09', 'non disponible', 'memoire', NULL, 'Mastere', NULL, '2024-11-16 19:12:51', '2024-11-16 19:12:51');

-- --------------------------------------------------------

--
-- Structure de la table `documents_authors`
--

DROP TABLE IF EXISTS `documents_authors`;
CREATE TABLE IF NOT EXISTS `documents_authors` (
  `document_id` int NOT NULL,
  `author_id` int NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`document_id`,`author_id`),
  KEY `author_id` (`author_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `documents_authors`
--

INSERT INTO `documents_authors` (`document_id`, `author_id`, `created_at`, `updated_at`) VALUES
(10, 1, '2024-11-12 10:55:19', '2024-11-12 10:55:19'),
(11, 1, '2024-11-12 10:55:53', '2024-11-12 10:55:53'),
(11, 2, '2024-11-12 10:55:53', '2024-11-12 10:55:53'),
(12, 4, '2024-11-16 09:51:40', '2024-11-16 19:06:25'),
(13, 5, '2024-11-16 19:14:21', '2024-11-16 19:14:21'),
(14, 2, '2024-11-16 19:11:37', '2024-11-16 19:11:37'),
(15, 2, '2024-11-16 19:12:52', '2024-11-16 19:12:52');

-- --------------------------------------------------------

--
-- Structure de la table `etageres`
--

DROP TABLE IF EXISTS `etageres`;
CREATE TABLE IF NOT EXISTS `etageres` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numEt` int NOT NULL,
  `placard_id` int DEFAULT NULL,
  `libelleEt` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `numEt` (`id`),
  KEY `id_placard` (`placard_id`),
  KEY `libelleEt` (`libelleEt`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `etageres`
--

INSERT INTO `etageres` (`id`, `numEt`, `placard_id`, `libelleEt`, `created_at`, `updated_at`) VALUES
(1, 1, 1, 'etage 1', '2024-11-16 11:49:26', '2024-11-16 14:00:01'),
(2, 2, 1, 'etage 2', '2024-11-16 11:51:45', '2024-11-16 14:00:09'),
(5, 1, 2, 'Etage 1', '2024-11-17 10:56:27', '2024-11-17 10:56:27'),
(6, 3, 1, 'etage 3', '2024-11-18 14:58:22', '2024-11-18 14:58:22');

-- --------------------------------------------------------

--
-- Structure de la table `exemplaires`
--

DROP TABLE IF EXISTS `exemplaires`;
CREATE TABLE IF NOT EXISTS `exemplaires` (
  `numEx` int NOT NULL AUTO_INCREMENT,
  `document_id` int NOT NULL,
  `etagere_id` int NOT NULL,
  `statut` enum('disponible','prete','exclu') COLLATE utf8mb4_unicode_ci DEFAULT 'disponible',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`numEx`),
  UNIQUE KEY `numEx` (`numEx`),
  KEY `document_id` (`document_id`),
  KEY `etagere_id` (`etagere_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `exemplaires`
--

INSERT INTO `exemplaires` (`numEx`, `document_id`, `etagere_id`, `statut`, `created_at`, `updated_at`) VALUES
(1, 10, 2, 'prete', '2024-11-16 14:14:12', '2024-11-17 19:57:21'),
(2, 10, 2, 'prete', '2024-11-16 14:14:13', '2024-11-18 14:39:06'),
(3, 12, 2, 'disponible', '2024-11-16 14:15:48', '2024-11-16 14:15:48'),
(4, 1, 1, 'disponible', '2024-11-16 14:36:36', '2024-11-16 14:36:36');

-- --------------------------------------------------------

--
-- Structure de la table `librarian`
--

DROP TABLE IF EXISTS `librarian`;
CREATE TABLE IF NOT EXISTS `librarian` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `librarian`
--

INSERT INTO `librarian` (`id`, `username`, `password`, `created_at`, `updated_at`) VALUES
(1, 'admin', '$2a$12$PTSQCYkZ.C5GqjDjyASaTeZTgheaY/LDQML31ZWtPVqEtjpahlmJW', '0000-00-00 00:00:00', '2024-11-21 10:56:46'),
(2, 'user', '$2a$12$N6ktykKBTjXqUrRfEjHjfeGBkQWheb9alPAQwXF50jI4iCkcP1tUa', '2024-11-03 14:57:03', '2024-11-21 10:28:27');

-- --------------------------------------------------------

--
-- Structure de la table `placards`
--

DROP TABLE IF EXISTS `placards`;
CREATE TABLE IF NOT EXISTS `placards` (
  `numPl` int NOT NULL AUTO_INCREMENT,
  `libellePl` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`numPl`),
  UNIQUE KEY `numPl` (`numPl`),
  UNIQUE KEY `libellePl` (`libellePl`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `placards`
--

INSERT INTO `placards` (`numPl`, `libellePl`, `created_at`, `updated_at`) VALUES
(1, 'Placard 1', '2024-11-16 11:11:37', '2024-11-16 11:11:37'),
(2, 'Placard 2', '2024-11-17 09:58:21', '2024-11-17 09:58:21');

-- --------------------------------------------------------

--
-- Structure de la table `pret`
--

DROP TABLE IF EXISTS `pret`;
CREATE TABLE IF NOT EXISTS `pret` (
  `numPr` int NOT NULL AUTO_INCREMENT,
  `exemplaire_id` int NOT NULL,
  `subscriber_id` int NOT NULL,
  `dateRetour` date DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`numPr`),
  UNIQUE KEY `numPr` (`numPr`),
  KEY `exemplaire_id` (`exemplaire_id`),
  KEY `subscriber_id` (`subscriber_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `pret`
--

INSERT INTO `pret` (`numPr`, `exemplaire_id`, `subscriber_id`, `dateRetour`, `created_at`, `updated_at`) VALUES
(1, 4, 1, '2024-11-17', '2024-11-11 23:00:00', '2024-11-17 21:45:31'),
(2, 3, 1, '2024-11-18', '2024-11-17 22:02:31', '2024-11-18 14:39:27'),
(3, 3, 2, NULL, '2024-11-18 14:39:06', '2024-11-18 14:39:06');

-- --------------------------------------------------------

--
-- Structure de la table `subscribers`
--

DROP TABLE IF EXISTS `subscribers`;
CREATE TABLE IF NOT EXISTS `subscribers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cin` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nom` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `adresse` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tel` int DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `cin` (`cin`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `subscribers`
--

INSERT INTO `subscribers` (`id`, `cin`, `nom`, `prenom`, `adresse`, `tel`, `created_at`, `updated_at`) VALUES
(1, '0556660', 'ben', 'Taw', 'tunis,tunisia', 55666666, '2024-11-13 13:20:15', '2024-11-14 19:33:53'),
(2, '01100', 'Benz', 'Ramzi', 'Nabeul', 21212453, '2024-11-14 09:22:13', '2024-11-14 09:22:13');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `documents_authors`
--
ALTER TABLE `documents_authors`
  ADD CONSTRAINT `documents_authors_ibfk_1` FOREIGN KEY (`document_id`) REFERENCES `documents` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `documents_authors_ibfk_2` FOREIGN KEY (`author_id`) REFERENCES `authors` (`code_auteur`) ON DELETE CASCADE;

--
-- Contraintes pour la table `etageres`
--
ALTER TABLE `etageres`
  ADD CONSTRAINT `etageres_ibfk_1` FOREIGN KEY (`placard_id`) REFERENCES `placards` (`numPl`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `exemplaires`
--
ALTER TABLE `exemplaires`
  ADD CONSTRAINT `exemplaires_ibfk_1` FOREIGN KEY (`document_id`) REFERENCES `documents` (`id`),
  ADD CONSTRAINT `exemplaires_ibfk_2` FOREIGN KEY (`etagere_id`) REFERENCES `etageres` (`id`);

--
-- Contraintes pour la table `pret`
--
ALTER TABLE `pret`
  ADD CONSTRAINT `pret_ibfk_1` FOREIGN KEY (`exemplaire_id`) REFERENCES `exemplaires` (`numEx`),
  ADD CONSTRAINT `pret_ibfk_2` FOREIGN KEY (`subscriber_id`) REFERENCES `subscribers` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
