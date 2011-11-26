-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 26. November 2011 um 21:31
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
  `songID` int(11) NOT NULL,
  `url` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `text` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`songID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Daten für Tabelle `lyric`
--

INSERT INTO `lyric` (`songID`, `url`, `text`) VALUES
(1, NULL, 'Mum mum mum mah \r\nMum mum mum mah \r\nMum mum mum mah \r\nMum mum mum mah\r\nI wanna hold ''em like they do in Texas please \r\nFold ''em let ''em hit me raise it baby stay with me (I love it) \r\nLuck and intuition play the cards with Spades to start \r\nAnd after he''s been hooked I''ll play the one that''s on his heart\r\nOh, oh, oh, oh, ohhhh, ohh-oh-e-ohh-oh-oh \r\nI''ll get him hot, show him what I''ve got \r\nOh, oh, oh, oh, ohhhh, ohh-oh-e-ohh-oh-oh, \r\nI''ll get him hot, show him what I''ve got [...] (Mum mum mum mah)\r\nPokerface');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `price`
--

CREATE TABLE IF NOT EXISTS `price` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `songID` int(11) NOT NULL,
  `provider` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `value` int(11) NOT NULL,
  `offerUrl` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

--
-- Daten für Tabelle `price`
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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `interpreter` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `date` date NOT NULL,
  `tracklength` int(11) NOT NULL,
  `video` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rating` float DEFAULT '0',
  `voteCount` int(11) NOT NULL DEFAULT '0',
  `voteTotal` int(11) NOT NULL DEFAULT '0',
  `picture` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=89 ;

--
-- Daten für Tabelle `song`
--

INSERT INTO `song` (`id`, `interpreter`, `title`, `date`, `tracklength`, `video`, `rating`, `voteCount`, `voteTotal`, `picture`) VALUES
(1, 'Rihanna feat. Calvin Harris', 'We Found Love', '2011-11-26', 276, '<a href="http://www.myvideo.de/watch/8301859/Rihanna_feat_Calvin_Harris_We_Found_Love">Rihanna_feat_Calvin_Harris_We_Found_Love</a>', 0, 0, 0, 'http://tracksnob.com/wp-content/uploads/2011/09/rihanna-feat-calvin-harris-we-found-love.jpeg'),
(2, 'Taio Cruz featuring Flo Rida', 'Hangover', '2011-11-26', 290, '<a href="http://www.myvideo.de/watch/8314947/Taio_Cruz_featuring_Flo_Rida_Hangover">Taio_Cruz_featuring_Flo_Rida_Hangover</a>', 0, 0, 0, 'http://freshnewtracks.com/wp-content/uploads/2011/08/taio_and_flo_rida__hangover_by_myteenagejukebox-d41f8y7-500x500.jpg'),
(3, 'Maroon 5 feat. Christina Aguilera', 'Moves Like Jagger', '2011-11-26', 281, '<a href="http://www.myvideo.de/watch/8231264/Maroon_5_feat_Christina_Aguilera_Moves_Like_Jagger">Maroon_5_feat_Christina_Aguilera_Moves_Like_Jagger</a>', 0, 0, 0, 'http://wac.450f.edgecastcdn.net/80450F/popcrush.com/files/2011/06/Moves-Like-Jagger.jpg'),
(4, 'Marlon Roudette', 'New Age ', '2011-11-26', 191, '<a href="http://www.myvideo.de/watch/8238018/Marlon_Roudette_New_Age_What_A_Man_Edit">Marlon_Roudette_New_Age_What_A_Man_Edit</a>', 0, 0, 0, 'http://2.bp.blogspot.com/-HL-ZkkfLABw/Tmqd3lM8jLI/AAAAAAAABBI/n25oLmrNqFY/s1600/MarlonRoudette-NewAge_cover.jpg'),
(5, 'Sean Paul', 'Got 2 Luv You', '2011-11-26', 208, '<a href="http://www.myvideo.de/watch/8268991/Sean_Paul_Got_2_Luv_You">Sean_Paul_Got_2_Luv_You</a>', 0, 0, 0, 'http://www.aceshowbiz.com/images/news/sean-paul-s-got-2-luv-u-ft-alexis-jordan.jpg'),
(6, 'Pitbull feat. Marc Anthony', 'Rain Over Me', '2011-11-26', 233, '<a href="http://www.myvideo.de/watch/8214647/Pitbull_feat_Marc_Anthony_Rain_Over_Me">Pitbull_feat_Marc_Anthony_Rain_Over_Me</a>', 0, 0, 0, 'http://1.bp.blogspot.com/-qSeE0PcYizk/TinH-j1PrmI/AAAAAAAABLE/vTFqzVNYfp4/s1600/rain-over-me.jpg'),
(7, 'David Guetta feat. Usher', 'Without You ', '2011-11-26', 210, '<a href="http://www.myvideo.de/watch/8294051/David_Guetta_feat_Usher_Without_You_Official_Video">David_Guetta_feat_Usher_Without_You_Official_Video</a>', 0, 0, 0, 'http://www.chartstats.com/images/artwork/44568.jpg'),
(8, 'R.I.O. feat. U-Jean', 'Turn This Club Around ', '2011-11-26', 207, '<a href="http://www.myvideo.de/watch/8267742/R_I_O_feat_U_Jean_Turn_This_Club_Around_Official_Video_HD">R_I_O_feat_U_Jean_Turn_This_Club_Around_Official_Video_HD</a>', 0, 0, 0, 'http://download.feiyr.com/cover/65/1/7000031098_1000.jpg'),
(9, 'Coldplay', 'Paradise', '2011-11-26', 261, '<a href="http://www.myvideo.de/watch/8301371/Coldplay_Paradise">Coldplay_Paradise</a>', 0, 0, 0, 'http://wac.450f.edgecastcdn.net/80450F/popcrush.com/files/2011/09/coldplay-paradise.jpg'),
(10, 'Glasperlenspiel', 'Echt', '2011-11-26', 197, '<a href="http://www.myvideo.de/watch/8233257/Glasperlenspiel_Echt">Glasperlenspiel_Echt</a>', 0, 0, 0, 'http://96rockplay.de/wp-content/uploads/2011/09/glasperlenspiel.jpg'),
(11, 'James Morrison', 'I Won''t Let You Go', '2011-11-26', 239, '<a href="http://www.myvideo.de/watch/8226682/James_Morrison_I_Won_t_Let_You_Go">James_Morrison_I_Won_t_Let_You_Go</a>', 0, 0, 0, 'http://www.aceshowbiz.com/images/news/james-morrison-s-i-won-t-let-you-go.jpg'),
(12, 'LMFAO', 'Sexy And I Know It', '2011-11-26', 205, '<a href="http://www.myvideo.de/watch/8269163/LMFAO_Sexy_And_I_Know_It">LMFAO_Sexy_And_I_Know_It</a>', 0, 0, 0, 'http://4.bp.blogspot.com/-p3AHFLwbbBs/Tf2l2GYIN8I/AAAAAAAAJes/n7TKNvtNL7M/s320/Sexy-And-I-Know-It-Lyrics-LMFAO.jpg'),
(13, 'Example', 'Changed The Way You Kiss Me', '2011-11-26', 203, '<a href="http://www.myvideo.de/watch/8224203/Example_Changed_The_Way_You_Kiss_Me">Example_Changed_The_Way_You_Kiss_Me</a>', 0, 0, 0, 'http://2.bp.blogspot.com/-sxh-tNaN3EA/TZ3iKWWBVqI/AAAAAAAAJ14/KJh-Wu7-j3c/s1600/Example-Changed-The-Way-you-Kiss-me.jpg'),
(14, 'Lucenzo', 'Danza Kuduro ', '2011-11-26', 240, '<a href="http://www.myvideo.de/watch/8170984/Lucenzo_Danza_Kuduro_feat_Don_Omar">Lucenzo_Danza_Kuduro_feat_Don_Omar</a>', 0, 0, 0, 'http://upload.wikimedia.org/wikipedia/en/thumb/1/1a/Danza_Kuduro_(single_cover).JPG/220px-Danza_Kuduro_(single_cover).JPG'),
(15, 'Sak Noel', 'Loca People ', '2011-11-26', 286, '<a href="http://www.myvideo.de/watch/8223662/Sak_Noel_Loca_People_What_the_F_k">Sak_Noel_Loca_People_What_the_F_k</a>', 0, 0, 0, 'http://2.bp.blogspot.com/-mtb3wYjJEtA/Te5MBOatE-I/AAAAAAAAEO0/vPBaTqmWnwU/s400/Sak-Noel-Loca-People-Cover.jpg'),
(16, 'Mike Candys & Evelyn feat Patrick Miller', 'One Night In Ibiza ', '2011-11-26', 174, '<a href="http://www.myvideo.de/watch/8245517/Mike_Candys_Evelyn_feat_Patrick_Miller_One_Night_In_Ibiza_Official_Video_HD">Mike_Candys_Evelyn_feat_Patrick_Miller_One_Night_In_Ibiza_Official_Video_HD</a>', 0, 0, 0, 'http://images.junostatic.com/full/CS1822723-02A-BIG.jpg'),
(17, 'Rosenstolz', 'Wir sind am Leben', '2011-11-26', 303, '<a href="http://www.myvideo.de/watch/8247707/Rosenstolz_Wir_sind_am_Leben">Rosenstolz_Wir_sind_am_Leben</a>', 0, 0, 0, 'http://www.trading-house.net/bilder/rosenstolz-schreiben-trotz-pause-neue-songs-441309_400_0.jpg'),
(18, 'Snow Patrol', 'Called Out In The Dark', '2011-11-26', 258, '<a href="http://www.myvideo.de/watch/8239540/Snow_Patrol_Called_Out_In_The_Dark">Snow_Patrol_Called_Out_In_The_Dark</a>', 0, 0, 0, 'http://4.bp.blogspot.com/-UPNghzUdWgI/Tk4vRqr4hUI/AAAAAAAAAlQ/hN-lEFNos8g/s1600/Snow-Patrol-Called-Out-In-The-Dark.jpg'),
(19, 'Tim Bendzko', 'Nur noch kurz die Welt retten ', '2011-11-26', 191, '<a href="http://www.myvideo.de/watch/8122228/Tim_Bendzko_Nur_noch_kurz_die_Welt_retten_Official_Video">Tim_Bendzko_Nur_noch_kurz_die_Welt_retten_Official_Video</a>', 0, 0, 0, 'http://www.fan-lexikon.de/musik/tim-bendzko/bilder/l/tim-bendzko-nur-noch-kurz-die-welt-retten-single-cover-14459.jpg'),
(20, 'Lana Del Rey', 'Video Games', '2011-11-26', 290, '<a href="http://www.myvideo.de/watch/8299299/Lana_Del_Rey_Video_Games">Lana_Del_Rey_Video_Games</a>', 0, 0, 0, 'http://upload.wikimedia.org/wikipedia/en/c/cf/Lana_Del_Rey_-_Video_Games_single_cover.png'),
(21, 'Tim Bendzko', 'Wenn Worte meine Sprache wären', '2011-11-26', 196, '<a href="http://www.myvideo.de/watch/8261169/Tim_Bendzko_Wenn_Worte_meine_Sprache_waeren">Tim_Bendzko_Wenn_Worte_meine_Sprache_waeren</a>', 0, 0, 0, 'http://www.fan-lexikon.de/musik/tim-bendzko/bilder/l/tim-bendzko-wenn-worte-meine-sprache-waeren-album-cover-14460.jpg'),
(22, 'DJ Antoine vs Timati feat. Kalenna', 'Welcome to St. Tropez', '2011-11-26', 222, '<a href="http://www.myvideo.de/watch/7999310/DJ_Antoine_vs_Timati_feat_Kalenna_Welcome_to_St_Tropez">DJ_Antoine_vs_Timati_feat_Kalenna_Welcome_to_St_Tropez</a>', 0, 0, 0, 'http://4.bp.blogspot.com/-j03E9WOiIUE/TkCf4owLcFI/AAAAAAAAAaw/Imp6OO0mRkA/s1600/Welcome%2BTo%2BSt.%2BTropez.jpg'),
(23, 'Natalia Kills', 'Free ', '2011-11-26', 280, '<a href="http://www.myvideo.de/watch/8197227/Natalia_Kills_Free_feat_will_i_am">Natalia_Kills_Free_feat_will_i_am</a>', 0, 0, 0, 'http://3.bp.blogspot.com/_mupIVJbjvuU/TFcX7x0y13I/AAAAAAAAFh4/yKpB7sJBjDE/s1600/Natalia%2BKills%2B-%2BMirrors%2B(Official%2BSingle%2BCover).jpg'),
(24, 'Seeed', 'Molotov / Wonderful Life', '2011-11-26', 374, '<a href="http://www.myvideo.de/watch/8267589/Seeed_Molotov_Wonderful_Life">Seeed_Molotov_Wonderful_Life</a>', 0, 0, 0, 'http://image.viduba.com/video--seeed-molotov-wonderful-life-official-video--QVlRVVlMG9kYsZ0bVpmRp5kVJp3Vn1TP.jpeg'),
(25, 'Alexandra Stan', 'Mr. Saxobeat', '2011-11-26', 194, '<a href="http://www.myvideo.de/watch/8095653/Alexandra_Stan_Mr_Saxobeat">Alexandra_Stan_Mr_Saxobeat</a>', 0, 0, 0, 'http://i61.servimg.com/u/f61/12/01/38/76/10169410.jpg'),
(26, 'Lady Gaga', 'Yoü And I', '2011-11-26', 381, '<a href="http://www.myvideo.de/watch/8240123/Lady_Gaga_Youe_And_I">Lady_Gaga_Youe_And_I</a>', 0, 0, 0, 'http://www.deviantart.com/download/182944587/lady_gaga___you_and_i_by_other_covers-d30x4y3.png'),
(27, 'Philipp Poisel', 'Eiserner Steg', '2011-11-26', 240, '<a href="http://www.myvideo.de/watch/8273666/Philipp_Poisel_Eiserner_Steg">Philipp_Poisel_Eiserner_Steg</a>', 0, 0, 0, 'http://image.viduba.com/video--philipp-poisel-eiserner-steg-klavier-version-offizielles-video--QVVM0dlVW9mVt5UTTxmVUVFbKVEVR1TP.jpeg'),
(28, 'Udo Lindenberg', 'Ein Herz kann man nicht reparieren', '2011-11-26', 234, '<a href="http://www.myvideo.de/watch/8248119/Udo_Lindenberg_Ein_Herz_kann_man_nicht_reparieren">Udo_Lindenberg_Ein_Herz_kann_man_nicht_reparieren</a>', 0, 0, 0, 'http://www.vinylsearcher.com/largeImages/31782600.jpg'),
(29, '30 Seconds To Mars', 'The Kill ', '2011-11-26', 336, '<a href="http://www.myvideo.de/watch/7088366/30_Seconds_To_Mars_The_Kill_Bury_Me">30_Seconds_To_Mars_The_Kill_Bury_Me</a>', 0, 0, 0, 'http://www.songonlyrics.com/wp-content/uploads/2010/12/11216.jpg'),
(30, 'Jupiter Jones', 'Still', '2011-11-26', 235, '<a href="http://www.myvideo.de/watch/8007102/Jupiter_Jones_Still">Jupiter_Jones_Still</a>', 0, 0, 0, 'http://image.kazaa.com/images/74/884977779974/Jupiter_Jones/Still/-Still_3.jpg'),
(31, 'Pitbull', 'Give Me Everything', '2011-11-26', 265, '<a href="http://www.myvideo.de/watch/8129658/Pitbull_Give_Me_Everything">Pitbull_Give_Me_Everything</a>', 0, 0, 0, 'http://upload.wikimedia.org/wikipedia/en/thumb/0/06/Pitbull_-_Give_Me_Everything.jpg/220px-Pitbull_-_Give_Me_Everything.jpg'),
(32, 'LMFAO', 'Party Rock Anthem ', '2011-11-26', 364, '<a href="http://www.myvideo.de/watch/8094578/LMFAO_Party_Rock_Anthem_Long_Version">LMFAO_Party_Rock_Anthem_Long_Version</a>', 0, 0, 0, 'http://3.bp.blogspot.com/-K_hTr_QG8cg/Ta1X8xFMDFI/AAAAAAAACs4/_RjGOetXB18/s1600/LMFAO%252B-%252BParty%252BRock%252BAnthem.jpg'),
(33, 'Kelly Clarkson', 'Mr. Know It All', '2011-11-26', 233, '<a href="http://www.myvideo.de/watch/8278858/Kelly_Clarkson_Mr_Know_It_All">Kelly_Clarkson_Mr_Know_It_All</a>', 0, 0, 0, 'http://poponandon.com/wp-content/uploads/2011/08/Kelly-Clarkson-Mr-Know-It-All-single-cover.jpg'),
(34, 'Rea Garvey', 'Can''t Stand The Silence', '2011-11-26', 217, '<a href="http://www.myvideo.de/watch/8248642/Rea_Garvey_Can_t_Stand_The_Silence">Rea_Garvey_Can_t_Stand_The_Silence</a>', 0, 0, 0, 'http://www.lyricshall.com/dbimages/albums/1318870242.jpg'),
(35, 'DJ Ötzi', 'I Sing A Liad Für Dich', '2011-11-26', 190, '<a href="http://www.myvideo.de/watch/8248635/DJ_Oetzi_I_Sing_A_Liad_Fuer_Dich">DJ_Oetzi_I_Sing_A_Liad_Fuer_Dich</a>', 0, 0, 0, 'http://a1.mzstatic.com/us/r2000/006/Music/b6/c5/71/mzi.cgyaynjp.170x170-75.jpg'),
(36, 'Jürgen Drews', 'Wenn die Wunderkerzen brennen', '2011-11-26', 211, '<a href="http://www.myvideo.de/watch/8276237/Juergen_Drews_Wenn_die_Wunderkerzen_brennen">Juergen_Drews_Wenn_die_Wunderkerzen_brennen</a>', 0, 0, 0, 'http://www.rudiworld.de/images/juergen-drews-wunderkerzen-.jpg'),
(37, 'Timbaland', 'Pass At Me feat. Pitbull', '2011-11-26', 257, '<a href="http://www.myvideo.de/watch/8274703/Timbaland_Pass_At_Me_feat_Pitbull">Timbaland_Pass_At_Me_feat_Pitbull</a>', 0, 0, 0, 'http://thehypefactor.com/wp-content/uploads/2011/09/Timbaland-Pass_at_Me-feat-Pitbull.jpg'),
(38, 'Jennifer Lopez', 'On The Floor ', '2011-11-26', 268, '<a href="http://www.myvideo.de/watch/8027063/Jennifer_Lopez_On_The_Floor_feat_Pitbull">Jennifer_Lopez_On_The_Floor_feat_Pitbull</a>', 0, 0, 0, 'onseData'),
(39, 'Katzenjammer', 'I Will Dance ', '2011-11-26', 225, '<a href="http://www.myvideo.de/watch/8230800/Katzenjammer_I_Will_Dance_When_I_Walk_Away">Katzenjammer_I_Will_Dance_When_I_Walk_Away</a>', 0, 0, 0, 'onseData'),
(40, 'Andreas Gabalier', 'I sing a Liad für di', '2011-11-26', 190, '<a href="http://www.myvideo.de/watch/8212448/Andreas_Gabalier_I_sing_a_Liad_fuer_di">Andreas_Gabalier_I_sing_a_Liad_fuer_di</a>', 0, 0, 0, 'onseData'),
(41, 'Frida Gold', 'Wovon sollen wir träumen', '2011-11-26', 209, '<a href="http://www.myvideo.de/watch/8050035/Frida_Gold_Wovon_sollen_wir_traeumen">Frida_Gold_Wovon_sollen_wir_traeumen</a>', 0, 0, 0, 'onseData'),
(42, 'Red Hot Chili Peppers', 'The Adventures Of Rain Dance Maggie', '2011-11-26', 285, '<a href="http://www.myvideo.de/watch/8240532/Red_Hot_Chili_Peppers_The_Adventures_Of_Rain_Dance_Maggie">Red_Hot_Chili_Peppers_The_Adventures_Of_Rain_Dance_Maggie</a>', 0, 0, 0, 'onseData'),
(43, 'Brooke Fraser', 'Something In The Water', '2011-11-26', 181, '<a href="http://www.myvideo.de/watch/8071152/Brooke_Fraser_Something_In_The_Water">Brooke_Fraser_Something_In_The_Water</a>', 0, 0, 0, 'onseData'),
(44, 'Lady Gaga', 'The Edge Of Glory', '2011-11-26', 323, '<a href="http://www.myvideo.de/watch/8178567/Lady_Gaga_The_Edge_Of_Glory">Lady_Gaga_The_Edge_Of_Glory</a>', 0, 0, 0, 'onseData'),
(45, 'Snoop Dogg vs. David Guetta', 'Sweat ', '2011-11-26', 196, '<a href="http://www.myvideo.de/watch/8038930/Snoop_Dogg_vs_David_Guetta_Sweat_David_Guetta_Remix">Snoop_Dogg_vs_David_Guetta_Sweat_David_Guetta_Remix</a>', 0, 0, 0, 'onseData'),
(46, 'David Guetta', 'Little Bad Girl ', '2011-11-26', 211, '<a href="http://www.myvideo.de/watch/8209600/David_Guetta_Little_Bad_Girl_feat_Taio_Cruz_Ludacris_Official_Video">David_Guetta_Little_Bad_Girl_feat_Taio_Cruz_Ludacris_Official_Video</a>', 0, 0, 0, 'onseData'),
(47, 'Jason Derulo', 'Don''t Wanna Go Home', '2011-11-26', 238, '<a href="http://www.myvideo.de/watch/8152738/Jason_Derulo_Don_t_Wanna_Go_Home">Jason_Derulo_Don_t_Wanna_Go_Home</a>', 0, 0, 0, 'onseData'),
(48, 'Madcon feat. Itchy & Maad*Moiselle', 'Helluva Nite', '2011-11-26', 211, '<a href="http://www.myvideo.de/watch/8259430/Madcon_feat_Itchy_Maad_Moiselle_Helluva_Nite">Madcon_feat_Itchy_Maad_Moiselle_Helluva_Nite</a>', 0, 0, 0, 'onseData'),
(49, 'Caro Emerald', 'Stuck', '2011-11-26', 233, '<a href="http://www.myvideo.de/watch/8241468/Caro_Emerald_Stuck">Caro_Emerald_Stuck</a>', 0, 0, 0, 'onseData'),
(50, 'The Black Eyed Peas', 'Don?t Stop The Party', '2011-11-26', 380, '<a href="http://www.myvideo.de/watch/8131187/The_Black_Eyed_Peas_Don_t_Stop_The_Party">The_Black_Eyed_Peas_Don_t_Stop_The_Party</a>', 0, 0, 0, 'onseData'),
(51, 'Beyonce', 'Best Thing I Never Had', '2011-11-26', 253, '<a href="http://www.myvideo.de/watch/8203303/Beyonce_Best_Thing_I_Never_Had">Beyonce_Best_Thing_I_Never_Had</a>', 0, 0, 0, 'onseData'),
(52, 'Caro Emerald', 'A Night Like This', '2011-11-26', 232, '<a href="http://www.myvideo.de/watch/7957791/Caro_Emerald_A_Night_Like_This">Caro_Emerald_A_Night_Like_This</a>', 0, 0, 0, 'onseData'),
(53, 'Bad Meets Evil featuring Bruno Mars', 'Lighters', '2011-11-26', 310, '<a href="http://www.myvideo.de/watch/8246493/Bad_Meets_Evil_featuring_Bruno_Mars_Lighters">Bad_Meets_Evil_featuring_Bruno_Mars_Lighters</a>', 0, 0, 0, 'onseData'),
(54, 'Leona Lewis', 'Run', '2011-11-26', 289, '<a href="http://www.myvideo.de/watch/5534429/Leona_Lewis_Run">Leona_Lewis_Run</a>', 0, 0, 0, 'onseData'),
(55, 'Coldplay', 'Every Teardrop Is A Waterfall', '2011-11-26', 243, '<a href="http://www.myvideo.de/watch/8192017/Coldplay_Every_Teardrop_Is_A_Waterfall">Coldplay_Every_Teardrop_Is_A_Waterfall</a>', 0, 0, 0, 'onseData'),
(56, 'David Guetta', 'Where Them Girls At ', '2011-11-26', 108, '<a href="http://www.myvideo.de/watch/8164326/David_Guetta_Where_Them_Girls_At_feat_Nicki_Minaj_Flo_Rida_Lyrics_Video_90_sec">David_Guetta_Where_Them_Girls_At_feat_Nicki_Minaj_Flo_Rida_Lyrics_Video_90_sec</a>', 0, 0, 0, 'onseData'),
(57, 'Milow', 'Little In The Middle', '2011-11-26', 189, '<a href="http://www.myvideo.de/watch/8206328/Milow_Little_In_The_Middle">Milow_Little_In_The_Middle</a>', 0, 0, 0, 'onseData'),
(58, 'The Good Natured', 'Skeleton', '2011-11-26', 188, '<a href="http://www.myvideo.de/watch/8111952/The_Good_Natured_Skeleton">The_Good_Natured_Skeleton</a>', 0, 0, 0, 'onseData'),
(59, 'Sunrise Avenue', 'I Don''t Dance', '2011-11-26', 218, '<a href="http://www.myvideo.de/watch/8210706/Sunrise_Avenue_I_Don_t_Dance">Sunrise_Avenue_I_Don_t_Dance</a>', 0, 0, 0, 'onseData'),
(60, 'Frida Gold', 'Unsere Liebe ist aus Gold', '2011-11-26', 208, '<a href="http://www.myvideo.de/watch/8273570/Frida_Gold_Unsere_Liebe_ist_aus_Gold">Frida_Gold_Unsere_Liebe_ist_aus_Gold</a>', 0, 0, 0, 'onseData'),
(61, 'Andreas Bourani', 'Nur in meinem Kopf', '2011-11-26', 234, '<a href="http://www.myvideo.de/watch/8123838/Andreas_Bourani_Nur_in_meinem_Kopf">Andreas_Bourani_Nur_in_meinem_Kopf</a>', 0, 0, 0, 'onseData'),
(62, 'Helene Fischer', 'Phänomen', '2011-11-26', 240, '<a href="http://www.myvideo.de/watch/8289564/Helene_Fischer_Phaenomen">Helene_Fischer_Phaenomen</a>', 0, 0, 0, 'onseData'),
(63, 'Zaz', 'Je Veux', '2011-11-26', 217, '<a href="http://www.myvideo.de/watch/7957724/Zaz_Je_Veux">Zaz_Je_Veux</a>', 0, 0, 0, 'onseData'),
(64, 'Bruno Mars', 'The Lazy Song', '2011-11-26', 198, '<a href="http://www.myvideo.de/watch/8094135/Bruno_Mars_The_Lazy_Song">Bruno_Mars_The_Lazy_Song</a>', 0, 0, 0, 'onseData'),
(65, 'Chris Brown', 'Beautiful People', '2011-11-26', 224, '<a href="http://www.myvideo.de/watch/8104400/Chris_Brown_Beautiful_People">Chris_Brown_Beautiful_People</a>', 0, 0, 0, 'onseData'),
(66, '23', 'So mach ich es', '2011-11-26', 401, '<a href="http://www.myvideo.de/watch/8325981/23_So_mach_ich_es">23_So_mach_ich_es</a>', 0, 0, 0, 'onseData'),
(67, 'Casper', 'So Perfekt', '2011-11-26', 225, '<a href="http://www.myvideo.de/watch/8199451/Casper_So_Perfekt">Casper_So_Perfekt</a>', 0, 0, 0, 'onseData'),
(68, 'Sunrise Avenue', 'Hollywood Hills', '2011-11-26', 210, '<a href="http://www.myvideo.de/watch/7999177/Sunrise_Avenue_Hollywood_Hills">Sunrise_Avenue_Hollywood_Hills</a>', 0, 0, 0, 'onseData'),
(69, 'Bag Raiders', 'Way Back Home', '2011-11-26', 217, '<a href="http://www.myvideo.de/watch/8104447/Bag_Raiders_Way_Back_Home">Bag_Raiders_Way_Back_Home</a>', 0, 0, 0, 'onseData'),
(70, 'Mark Medlock', 'The Other Side Of Broken', '2011-11-26', 236, '<a href="http://www.myvideo.de/watch/8293271/Mark_Medlock_The_Other_Side_Of_Broken">Mark_Medlock_The_Other_Side_Of_Broken</a>', 0, 0, 0, 'onseData'),
(71, 'WHITE APPLE TREE', 'Snowflakes ', '2011-11-26', 162, '<a href="http://www.myvideo.de/watch/8002390/WHITE_APPLE_TREE_Snowflakes_TIL_VS_VANDERTONE_MIX">WHITE_APPLE_TREE_Snowflakes_TIL_VS_VANDERTONE_MIX</a>', 0, 0, 0, 'onseData'),
(72, 'Bruno Mars', 'Grenade', '2011-11-26', 221, '<a href="http://www.myvideo.de/watch/7898308/Bruno_Mars_Grenade">Bruno_Mars_Grenade</a>', 0, 0, 0, 'onseData'),
(73, 'Bosse', 'Frankfurt Oder feat. Anna Loos ', '2011-11-26', 189, '<a href="http://www.myvideo.de/watch/8254640/Bosse_Frankfurt_Oder_feat_Anna_Loos_Silly">Bosse_Frankfurt_Oder_feat_Anna_Loos_Silly</a>', 0, 0, 0, 'onseData'),
(74, 'Jessie J', 'Price Tag ', '2011-11-26', 247, '<a href="http://www.myvideo.de/watch/8060452/Jessie_J_Price_Tag_feat_B_o_B">Jessie_J_Price_Tag_feat_B_o_B</a>', 0, 0, 0, 'onseData'),
(75, 'Rihanna', 'California King Bed', '2011-11-26', 285, '<a href="http://www.myvideo.de/watch/8130532/Rihanna_California_King_Bed">Rihanna_California_King_Bed</a>', 0, 0, 0, 'onseData'),
(76, 'Mickie Krause', 'Schatzi Schenk Mir Ein Foto ', '2011-11-26', 218, '<a href="http://www.myvideo.de/watch/8207619/Mickie_Krause_Schatzi_Schenk_Mir_Ein_Foto_Xtreme_Sound_Partyversion">Mickie_Krause_Schatzi_Schenk_Mir_Ein_Foto_Xtreme_Sound_Partyversion</a>', 0, 0, 0, 'onseData'),
(77, 'Andreas Bourani', 'Eisberg', '2011-11-26', 236, '<a href="http://www.myvideo.de/watch/8253153/Andreas_Bourani_Eisberg">Andreas_Bourani_Eisberg</a>', 0, 0, 0, 'onseData'),
(78, 'Pigeon John', 'The Bomb', '2011-11-26', 205, '<a href="http://www.myvideo.de/watch/8160679/Pigeon_John_The_Bomb">Pigeon_John_The_Bomb</a>', 0, 0, 0, 'onseData'),
(79, 'Gypsy & The Cat', 'Jona Vark', '2011-11-26', 213, '<a href="http://www.myvideo.de/watch/7987439/Gypsy_The_Cat_Jona_Vark">Gypsy_The_Cat_Jona_Vark</a>', 0, 0, 0, 'onseData'),
(80, 'Unheilig', 'Geboren um zu leben', '2011-11-26', 228, '<a href="http://www.myvideo.de/watch/7248366/Unheilig_Geboren_um_zu_leben">Unheilig_Geboren_um_zu_leben</a>', 0, 0, 0, 'onseData'),
(81, 'Jennifer Lopez featuring Lil Wayne', 'I''m Into You', '2011-11-26', 258, '<a href="http://www.myvideo.de/watch/8120716/Jennifer_Lopez_featuring_Lil_Wayne_I_m_Into_You">Jennifer_Lopez_featuring_Lil_Wayne_I_m_Into_You</a>', 0, 0, 0, 'onseData'),
(82, 'Wiz Khalifa', 'Black And Yellow', '2011-11-26', 220, '<a href="http://www.myvideo.de/watch/7991482/Wiz_Khalifa_Black_And_Yellow">Wiz_Khalifa_Black_And_Yellow</a>', 0, 0, 0, 'onseData'),
(83, 'Katy Perry', 'Last Friday Night  Extended Version', '2011-11-26', 486, '<a href="http://www.myvideo.de/watch/8172031/Katy_Perry_Last_Friday_Night_T_G_I_F_Extended_Version">Katy_Perry_Last_Friday_Night_T_G_I_F_Extended_Version</a>', 0, 0, 0, 'onseData'),
(84, 'Scooter', 'David Doesn''t Eat', '2011-11-26', 222, '<a href="http://www.myvideo.de/watch/8296293/Scooter_David_Doesn_t_Eat">Scooter_David_Doesn_t_Eat</a>', 0, 0, 0, 'onseData'),
(85, 'Roger Cicero', 'In diesem Moment', '2011-11-26', 211, '<a href="http://www.myvideo.de/watch/8315191/Roger_Cicero_In_diesem_Moment">Roger_Cicero_In_diesem_Moment</a>', 0, 0, 0, 'onseData'),
(86, 'Inna', 'Sun Is Up', '2011-11-26', 194, '<a href="http://www.myvideo.de/watch/8055860/Inna_Sun_Is_Up">Inna_Sun_Is_Up</a>', 0, 0, 0, 'onseData'),
(87, 'DJ Antoine ft. The Beat Shakers', 'Ma Chérie ', '2011-11-26', 201, '<a href="http://www.myvideo.de/watch/8322990/DJ_Antoine_ft_The_Beat_Shakers_Ma_Ch_rie_DJ_Antoine_vs_Mad_Mark_2k12_Edit">DJ_Antoine_ft_The_Beat_Shakers_Ma_Ch_rie_DJ_Antoine_vs_Mad_Mark_2k12_Edit</a>', 0, 0, 0, 'onseData'),
(88, 'Chris Brown feat Justin Bieber', 'Next To You', '2011-11-26', 361, '<a href="http://www.myvideo.de/watch/8190729/Chris_Brown_feat_Justin_Bieber_Next_To_You">Chris_Brown_feat_Justin_Bieber_Next_To_You</a>', 0, 0, 0, 'onseData');

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
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Daten für Tabelle `user`
--

INSERT INTO `user` (`id`, `email`, `password`) VALUES
(1, 'asd@asd.de', 'asd'),
(2, 'Mateful@web.de', '73675debcd8a436be48ec22211dcf44fe0df0a64');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
