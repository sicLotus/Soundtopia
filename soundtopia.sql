-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 18. Dezember 2011 um 16:11
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
-- Tabellenstruktur für Tabelle `chart`
--

CREATE TABLE IF NOT EXISTS `chart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `lastUpdated` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=11 ;

--
-- Daten für Tabelle `chart`
--

INSERT INTO `chart` (`id`, `name`, `lastUpdated`) VALUES
(1, 'Singlecharts', '2011-11-28 00:00:00'),
(2, 'Singlecharts', '2011-12-08 01:08:16'),
(3, 'Singlecharts', '2011-12-08 01:16:52'),
(4, 'Singlecharts', '2011-12-08 01:18:58'),
(9, 'Singlecharts', '2011-12-17 18:00:45'),
(10, 'Singlecharts', '2011-12-17 18:11:08');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `lyric`
--

CREATE TABLE IF NOT EXISTS `lyric` (
  `songID` int(11) NOT NULL,
  `url` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `text` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`songID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Daten für Tabelle `lyric`
--

INSERT INTO `lyric` (`songID`, `url`, `text`) VALUES
(1, 'http://lyrics.wikia.com/Lana_Del_Rey:Video_Games', 'Swinging in the backyard\nPull up in your fast car\nWhistling my name\nOpen up a beer\nAnd you say get over here\nAnd play a video game\n\nI''m in his favourite sun dress\nWatching me get undressed\nTake that body downtown\nI say you the bestest\nLean in for a big kiss\nP[...]'),
(2, 'http://lyrics.wikia.com/Taio_Cruz:Hangover', '[Taio Cruz - Hook]\nI got a hangover, wo-oh!\nI''ve been drinking too much for sure\nI got a hangover, wo-oh!\nI got an empty cup\nPour me some more\n\nSo I can go until they close up, eh\nAnd I can drink until I''m told up, eh\nAnd I don''t ever ever want to grow up, eh\nI want to[...]'),
(3, 'http://lyrics.wikia.com/Rihanna:We_Found_Love', 'Yellow Diamonds in lights \nAnd we''re standing side by side\nAs your shadow crosses mine\nWhat it takes to come alive\n\nIt''s the way I’m feeling I ju[...]'),
(4, 'http://lyrics.wikia.com/Gotye:Somebody_That_I_Used_To_Know', '<b>Gotye</b>\nNow and then I think of when we were together\nLike when you said you felt so happy you could die\nTold myself that you were right for me\nBut felt so lonely in your company\nBut that was love and it''s an ache I still remember\n\nYou [...]'),
(5, 'http://lyrics.wikia.com/Flo_Rida:Good_Feeling', '... oh, oh, oh\nOh, oh, sometimes I get a good feeling, yeah\nI get a feeling that I never never never never had before, no no\nI get a good feeling, yeah\n\nOh oh, sometimes I get a good feeling, yeah\nI get a feeling that I never never never never had before, no no\nI get a good feeling, yeah\n\nYes I can, doubt that I leave, I''m running with this plan\nPull me, grab [...]'),
(6, 'http://lyrics.wikia.com/index.php?title=P%21NK:Bridge+Of+Light&amp;action=edit', 'Not found'),
(7, 'http://lyrics.wikia.com/Udo_Lindenberg:Cello', 'Getrampt oder mit ''m Moped \noder schwarz mit der Bahn \nimmer bin ich dir irgendwie \nhinterhergefahren \nnein, damals hab[...]'),
(8, 'http://lyrics.wikia.com/index.php?title=David_Pfeffer:I%C3%82%C2%B4m+Here&amp;action=edit', 'Not found'),
(9, 'http://lyrics.wikia.com/Avicii:Levels', 'Oh, sometimes\nGet a good feeling, yeah[...]'),
(10, 'http://lyrics.wikia.com/Marlon_Roudette:New_Age', 'If love was a word,\nI don''t understand.\nThe simplest sound,\nWith four letters.\nWhatever it was,\nI''m over it now.\nWith every day,\nIt gets better,\nIt gets better.\n\nAre you lovin[...]'),
(11, 'http://lyrics.wikia.com/Bruno_Mars:It_Will_Rain', 'If you ever leave me, baby, \nLeave some morphine at my door\n''Cause it would take a whole lot of medication\nTo realize what we used to have, \nWe don''t have it anymore.\n\nThere''s no religion that could save me\nNo matter [...]'),
(12, 'http://lyrics.wikia.com/Foster_The_People:Pumped_Up_Kicks', 'Robert''s got a quick hand\nHe''ll look around the room, he won''t tell you his plan\nHe''s got a rolled cigarette\nHanging out his mouth, he''s a cowboy kid\nYeah, he found a six-shooter gun\nIn his dad''s closet with a box of fun things \nAnd I don''t even know what\nBut he''s coming for you, yeah, h[...]'),
(13, 'http://lyrics.wikia.com/Pitbull:Rain_Over_Me', '''''[Marc Anthony]''''\nGirl, my body don''t lie (RedOne)\nI''m outta my mind\nLet it rain over me (Mr. Worldwide)\nI''m rising so high\nOut of my mind (Marc Anthony)\nSo let it rain over me\n\nAy ay ay\nAy ay ay\nLet it rain over me\nAy ay ay\nAy ay ay\nLet it rain over me\n\n''''[Pitbull]''''\nA billion''s the new million\nVoli''s the new vodka\n40''s the[...]'),
(14, 'http://lyrics.wikia.com/Maroon_5:Moves_Like_Jagger', 'Oh! Oh!\nJust shoot for the stars\nIf it feels right\nThen aim for my heart\nIf you feel like\nAnd take me away\nAnd make it OK\nI swear I’ll behave\n\nYou wanted control\nSo we waited\nI put on a show\nNow I make it\nYou say I’m a kid\nMy ego is big\nI don’t give a shit!\n\nAnd it goes like this\nTake me by the tongue\n[...]'),
(15, 'http://lyrics.wikia.com/LMFAO:Sexy_And_I_Know_It', 'Yeah, yeah\nWhen I walk on by, girls be looking like damn he fly\nI pay to the beat, walking down the street with my new la freak, yeah\nThis is how I roll, animal print pants out control,\nIt''s RedFoo with the big ass ''fro\nThey like Bruce Lee rock at the [...]'),
(16, 'http://lyrics.wikia.com/Nickelback:When_We_Stand_Together', 'One more depending on a prayer\nAnd we all look away\nPeople pretending everywhere\nIt''s just another day\nThere''s bullets flying through the air\nAnd they still carry on\nWe watch it happen over there\nAnd then just turn it off\n\n(Hey, yeah[...]'),
(17, 'http://lyrics.wikia.com/David_Guetta:Without_You', 'I can''t win, I can''t reign\nI will never win this game\nWithout you, without you\nI am lost, I am vain,\nI will never be the same\nWi[...]'),
(18, 'http://lyrics.wikia.com/Christina_Perri:Jar_Of_Hearts', 'No, I can''t take one more step towards you\n''Cause all that''s waiting is regret\nAnd don''t you know I''m not your ghost anymore\nYou lost the love I loved the most\n\nI learned to live half alive\nAnd now you want me one more time\n\nAn[...]'),
(19, 'http://lyrics.wikia.com/index.php?title=Sean_Paul:Got+2+Luv+You&amp;action=edit', 'Not found'),
(20, 'http://lyrics.wikia.com/Lady_Gaga:Marry_The_Night', 'I''m gonna marry the night\nI won''t give up on my life\nI''m a warrior queen\nLive passionately tonight\n\nI''m gonna marry the dark\nGonna make love to the stark\nI''m a soldier to my\nOwn emptiness, I''m a winner\n\nI''m gonna marry the night\nI''m gonna marry the night\nI''m gonna marry [...]'),
(21, 'http://lyrics.wikia.com/Tim_Bendzko:Wenn_Worte_Meine_Sprache_W%C3%A4ren', 'Wenn Worte meine Sprache wären\nIch hät dir schon gesagt\nIn all den schönen Worten\nWie viel mir an dir lag\nIch kann dich nur ansehen\nWeil ich dich wie eine königin verehr\nDoch ich kann nicht auf dich zugehen\nWeil meine Angst den Weg versperrt\n\nChorus:\n\nMir fehlen die Worte ich\nHab die Worte nicht\nDi[...]'),
(22, 'http://lyrics.wikia.com/Tim_Bendzko:Nur_Noch_Kurz_Die_Welt_Retten', 'Ich wär so gern dabei gewesen \ndoch ich hab viel zu viel zu tun\nlass uns später weiter reden \nDa draußen brauchen sie mich jetzt \ndie Situation wird unterschätzt \nUnd vielleicht hängt unser Leben davon ab \nIch weiß es ist dir ernst \ndu kannst[...]'),
(23, 'http://lyrics.wikia.com/Coldplay:Paradise', 'When she was just a girl\nShe expected the world\nBut it flew away from her reach\nSo she ran away in her sleep\n\nAnd dreamed of para-para-pa[...]'),
(24, 'http://lyrics.wikia.com/Jason_Der%C3%BClo:It_Girl', 'I''ve been looking under rocks and breaking locks\nJust tryna find ya\nI''ve been like a maniac insomniac\nFive steps behind ya\n\nTell them other girls, they can hit the exit\nCheck please...\nCause I finally found the girl of... my dreams\nMuch more than a Grammy award\nThat''s how much you mean to me\n\nYou could b[...]'),
(25, 'http://lyrics.wikia.com/R.I.O.:Turn_This_Club_Around', 'Turn this club around\nAyo ayo\nAyo ayo\n\nIf you want more\nJust check my swagger out there on the dance floor\nYeah all the ladies gonna knock on my door\nGonna be the time of your life\nWe gonna do it tonight\nDo it tonight\n\nSomething''s heatin'' up, heatin'' up\nGo check my floor\nHey, meet me up, meet me up\nOn th[...]'),
(26, 'http://lyrics.wikia.com/index.php?title=Glasperlenspiel:Echt&amp;action=edit', 'Not found'),
(27, 'http://lyrics.wikia.com/Wham%21:Last_Christmas', 'Last Christmas I gave you my heart\nBut the very next day you gave it away\nThis year, to save me from tears,\nI''ll give it to someone special\n\nLast Christmas I gave you my heart\nBut the very next day you gave it away\nThis year, to save me from tea[...]'),
(28, 'http://lyrics.wikia.com/Jessie_J:Domino', 'I''m feeling sexy and free\nLike glitter''s raining on me\nYou like a shot of pure gold\nI think I''m ''bout to explode\n\nI can taste the tension like a cloud of smoke in the air\nNow I''m breathing like I''m running cause you''re taking me there\nDon''t you know... you spin me out o[...]'),
(29, 'http://lyrics.wikia.com/The_BossHoss:Don%27t_Gimme_That', '<Ah don''t gimme that (Don''t gimme that)\nDon''t gimme that (Don''t gimme that)\nDon''t gimme that\n\nTake my body, take my soul\nBut don''t take my rock n roll\nDon''t you dare, I''ll (???)\nHold your tongue but don''t gimme that\n\n[...]'),
(30, 'http://lyrics.wikia.com/LMFAO:Party_Rock_Anthem', '''''Party rock! Yeah! Whoo! Let''s go!''''\n\nParty rock is in the house tonight\nEverybody just have a good time ''''(yeah)''''\nAnd we gon'' make you lose your mind ''''(whoo!)''''\nEverybody just have a good time ''''(clap!)''''\n\nParty rock is in the house tonight ''''(oh!)''''\nEverybody just have a good time ''''(Like the feelin, mane!)''''\nAnd we gon'' make you lose your mind ''''(yeah!)''''\nWe just wanna see [...]'),
(31, 'http://lyrics.wikia.com/index.php?title=23:Erwachsen+Sein&amp;action=edit', 'Not found'),
(32, 'http://lyrics.wikia.com/index.php?title=DJ_Antoine:Ma+Ch%C3%83%C2%A9rie&amp;action=edit', 'Not found'),
(33, 'http://lyrics.wikia.com/Snow_Patrol:Called_Out_In_The_Dark', 'It''s like we just can''t help ourselves\nCause we don''t know how to back down\nWe were called out to the streets\nWe were called out into the towns\n\nAnd how the [...]'),
(34, 'http://lyrics.wikia.com/Ed_Sheeran:The_A_Team', 'White lips, pale face \nBreathing in snowflakes \nBurnt lungs, sour taste \nLight''s gone, day''s end \nStruggling to pay rent \nLong nights, strange men \n\nAnd they say \nShe''s in the Class A Team \nStuck in her daydream \nBeen this way since 18 \nBut lately her face seems \n[...]'),
(35, 'http://lyrics.wikia.com/Katy_Perry:The_One_That_Got_Away', 'Summer after high school, when we first met\nWe make-out in your Mustang to [[Radiohead]]\nAnd on my 18th birthday,\nWe got matching tattoos\n\nUsed to steal your parents'' liquor and climb to the roof\nTalk about our future like we had a c[...]'),
(36, 'http://lyrics.wikia.com/Kelly_Rowland:Down_For_Whatever', '[Intro]\nI''m down for whatever\nI''m down for whatever\nWhen it comes to you\nI could make love on the floor\nI''m down for whatever\nI''m down for whatever\nBaby let''s get creative\nCause of you I am down\nI''m down for whatever\n\n[Verse]\nThere''s no place I wouldn''t go\nTonight I''m ready to take it anywhere\nI''m amazed, by you all\nYou br[...]'),
(37, 'http://lyrics.wikia.com/Mariah_Carey:All_I_Want_For_Christmas_Is_You', 'I don''t want a lot for Christmas\nThere is just one thing I need\nI don''t care about the presents\nUnderneath the Christmas tree\nI just want you for my own\nMore than you could ever know\nMake my wish come true\nAll I want[...]'),
(38, 'http://lyrics.wikia.com/index.php?title=Yiruma:River+Flows+In+You&amp;action=edit', 'Not found'),
(39, 'http://lyrics.wikia.com/index.php?title=Pietro_Lombardi:Goin%27+To+L.A.&amp;action=edit', 'Not found'),
(40, 'http://lyrics.wikia.com/index.php?title=Lucenzo:Danza+Kuduro&amp;action=edit', 'Not found'),
(41, 'http://lyrics.wikia.com/index.php?title=R.J.:U+Know+It+Ain%27t+Love&amp;action=edit', 'Not found'),
(42, 'http://lyrics.wikia.com/Rosenstolz:Wir_Sind_Am_Leben', 'Hast du alles probiert?\nHast du alles versucht?\nHast du alles getan?\nWenn nicht, fang an!\n\nHast du wirklich gelebt?\nHat deine Welt sich wirklich gedreht?\nHast du alles getan?\nWenn nicht, fang an!\n\nW[...]'),
(43, 'http://lyrics.wikia.com/index.php?title=DJ_%C3%96tzi:Ring+The+Bell&amp;action=edit', 'Not found'),
(44, 'http://lyrics.wikia.com/James_Morrison:I_Won%27t_Let_You_Go', 'When it''s black\nTake a little time to hold yourself\nTake a little time to feel around\nBefore it''s gone\n\nYou won''t let go\nBut still do you keep on falling down\nRemember how you saved me no[...]'),
(45, 'http://lyrics.wikia.com/Melanie_Thornton:Wonderful_Dream_%28Holidays_Are_Coming%29', 'When the world is ever changing\nLike a candle in the dark\nThere''s a source of inspiration in the air\nLet the magic dry your tears and heal your heart\n\nA wonde[...]'),
(46, 'http://lyrics.wikia.com/index.php?title=DJ_Antoine_Vs_Timati:Welcome+to+St.+Tropez&amp;action=edit', 'Not found'),
(47, 'http://lyrics.wikia.com/index.php?title=Culcha_Candela:Hungry+Eyes&amp;action=edit', 'Not found'),
(48, 'http://lyrics.wikia.com/index.php?title=Nena%2C_Rea_Garvey%2C_Xavier_Naidoo%2C_The_BossHoss:Heroes+%2F+Helden&amp;action=edit', 'Not found'),
(49, 'http://lyrics.wikia.com/index.php?title=R.I.O.:Animal&amp;action=edit', 'Not found'),
(50, 'http://lyrics.wikia.com/Alexandra_Stan:Mr._Saxobeat', 'You make me this,\nBring me up,\nBring me down,\nPlaying sweet,\nMake me move like a freak,\nMr. Saxobeat.\n\nHe makes me this,\nBrings me up,\nBrings me down,\nDancing sweet,\nMakes me move like a freak, ''''(Mr. Saxobeat)''''\nMr. Saxobea[...]'),
(51, 'http://lyrics.wikia.com/Kelly_Clarkson:Mr._Know_It_All', 'Mr. Know It All\nWell ya think you know it all\nBut ya don''t know a thing at all\nAin''t it, ain''t it something y''all\nWhen somebody tells you something ''bout you\nThink that they know you more than you do\nSo you take it down, another pill to swallow\n\nMr. Bring Me Down\nWell ya, ya like to bring m[...]'),
(52, 'http://lyrics.wikia.com/Andreas_Gabalier:I_Sing_A_Liad_F%C3%BCr_Di', 'I sing a liad für di\nUnd daun frogst du mi\nMogst mid mir daunzn gehn\nI glaub i steh auf di\n\nI sing a liad für die\nUnd kaun di sterndal seng\nI hob mi verknoid in di\n\nI hob a engal gseng\nÜber di strossn gehn\nEs hod so liab glocht\nIn an[...]'),
(53, 'http://lyrics.wikia.com/index.php?title=Mike_Candys_%26_Evelyn_Feat_Patrick_Miller:One+Night+In+Ibiza&amp;action=edit', 'Not found'),
(54, 'http://lyrics.wikia.com/index.php?title=Redd:I%27m+Day+Dreaming&amp;action=edit', 'Not found'),
(55, 'http://lyrics.wikia.com/Sak_Noel:Loca_People', 'All Day All Night\nAll Day All Night\nAll Day All Night\nAll Day All Night\nAll Day All Night\nAll Day All Night\nAll Day All Night\nWHAT TH[...]'),
(56, 'http://lyrics.wikia.com/Jennifer_Lopez:On_The_Floor', '''''''Pitbull:''''''\nJ. Lo!\nThe other side, out my mine\n\n''''''Jennifer Lopez:''''''\nIt''s a new generation \n(Mr. Worldwide)\nOf party people\n\n''''''Pitbull:''''''\nGet on the floor, dale!\nGet on the floor\n({{wp|RedOne}}!)\n\n''''''Jennifer Lopez:''''''\nLet me introduce you to my party people\nIn the club...\n\n''''''Pitbull:''''''\nI''m loose\nAnd everybody knows I get off the train\nBaby, it''s t[...]'),
(57, 'http://lyrics.wikia.com/Justin_Bieber:Mistletoe', 'It’s the most beautiful time of the year\nLights fill the streets spreading so much cheer\nI should be playing in the winter snow\nBut I''mma be under the mistletoe\n\nI don’t want to miss out on the holiday\nBut I can’t stop staring at your face\nI shou[...]'),
(58, 'http://lyrics.wikia.com/Pitbull:Give_Me_Everything', '''''''Pitbull''''''\nMe not working hard?\nYeah right picture that with a Kodak\nOr better yet, go to Times Square\nTake a picture of me with a Kodak\nTook my life from negative to positive\nI just want y''all to know that\nAnd tonight, let''s enjoy life\nPitbull, Nayer, Ne-Yo that''s right\n\n''''''Ne-Yo''''''\nTonight I want all of you tonight\nGive me everything tonight\nFor all we know we might not get tomorrow\nLet''s do it tonight\n\n''''''Nayer''''''\nDon''t care what they say\nAll the game[...]'),
(59, 'http://lyrics.wikia.com/Sunrise_Avenue:Hollywood_Hills', 'Now this is not the time or the place\nFor a broken-hearted\n''Cause this is the end of the rainbow\nWhere no one can be too sad\n\nNo, I don''t wanna leave\nBut I must keep moving ahead\n''Cause my life belongs to the o[...]'),
(60, 'http://lyrics.wikia.com/index.php?title=Reamonn:Can%27t+Stand+The+Silence&amp;action=edit', 'Not found'),
(61, 'http://lyrics.wikia.com/Caro_Emerald:A_Night_Like_This', 'From where you are\nYou see the smoke start to arise\nWhere they play cards\n\nAnd you walk over\nSoftly moving passed the guards\nThe stakes are getting higher\nYou can feel it in your heart\n\nHe calls you bluff\nHe is the ace you never thought\nHe played t[...]'),
(62, 'http://lyrics.wikia.com/index.php?title=Ella_Endlich:K%C3%83%C2%BCss+Mich%2C+Halt+Mich%2C+Lieb+Mich&amp;action=edit', 'Not found'),
(63, 'http://lyrics.wikia.com/Jupiter_Jones:Still', 'So still, dass jeder von uns wusste, das hier ist\nfür immer, für immer und ein Leben und es war\nso still, dass jeder von uns ahnte, hierfür gibts kein Wort, \ndas jemals das Gefühl beschreiben kann.\n\nSo still, dass alle Uhren schwiegen,\nja, die Zeit k[...]'),
(64, 'http://lyrics.wikia.com/index.php?title=Snoop_Dogg_Vs._David_Guetta:Sweat&amp;action=edit', 'Not found'),
(65, 'http://lyrics.wikia.com/index.php?title=Scooter:C%27est+Bleu&amp;action=edit', 'Not found'),
(66, 'http://lyrics.wikia.com/index.php?title=Sido:Geboren+um+frei+zu+sein&amp;action=edit', 'Not found'),
(67, 'http://lyrics.wikia.com/Band_Aid_20:Do_They_Know_It%27s_Christmas%3F', '''''''Chris Martin:''''''\nIt''s Christmas time, there''s no need to be afraid\nAt Christmas time, we let in light and we banish shade\n\n''''''Dido:''''''\nAnd in our world of plenty we can spread a smile of joy\nThrow your arms around the world at Christmastime\n\n''''''Robbie Williams:''''''\nBut say a prayer, Pray for the other ones\nAt Christmas [...]'),
(68, 'http://lyrics.wikia.com/Example:Changed_The_Way_You_Kiss_Me', 'I''ve never been afraid of the highest heights \nOr afraid of flying, no\nI''ve never been afraid of the wildest fights \nNot afraid of dying \nBut now I want off this ride ''cause your scaring me\nAnd I don''t like wh[...]'),
(69, 'http://lyrics.wikia.com/Lady_Gaga:The_Edge_Of_Glory', 'There ain''t no reason you and me should be alone\nTonight, yeah, baby\nTonight, yeah, baby\nI got a reason that you''re who should take me home tonight\n\nI need a man that thinks it''s right when it''s so wrong\nTonight, yeah, baby\nTonight, yeah, baby\nRight on the [...]'),
(70, 'http://lyrics.wikia.com/Udo_Lindenberg:Ein_Herz_Kann_Man_Nicht_Reparieren', 'Hör'' mir jetzt mal zu, laß mich jetzt in Ruh''\nund ruf'' mich nicht mehr an...\nIch hab'' keine Zeit, nicht gestern und nicht heut'',\nnicht morgen und nicht irgendwann\nMach dir endlich klar...es ist nicht mehr - es war...\n\nDu mußt das kapier''n, eins wird nicht passiern''n,\nmich kri[...]'),
(71, 'http://lyrics.wikia.com/Bruno_Mars:Grenade', 'Easy come, easy go, that''s just how you l[...]'),
(72, 'http://lyrics.wikia.com/Kool_Savas:Aura', 'Als wär'' das hier mein erster und mein letzter Track\nKeine Promo, ich will nich'' mehr dein Interesse wecken\nDu weißt, was hier Phase is'', der Abspann zu Kanack-Attack\nTrending Topic auf Twitter, ihr braucht das nich'' ma'' mehr leugnen\nShit, jetzt is'' Essah back\nBring'' die Dinge auf den Punkt - SMS\nPumpt''s in den Genelecs, ich lauf'' hier über Wasser grad''\nSie fürchten nix wie die Wahrheit, drum brüll'' ich''s raus\nUnd blas'' meine Lun[...]'),
(73, 'http://lyrics.wikia.com/index.php?title=Frida_Gold:Wovon+sollen+wir+tr%C3%83%C2%A4umen&amp;action=edit', 'Not found'),
(74, NULL, NULL),
(75, 'http://lyrics.wikia.com/index.php?title=Seeed:Molotov+%2F+Wonderful+Life&amp;action=edit', 'Not found'),
(76, 'http://lyrics.wikia.com/David_Guetta:Little_Bad_Girl', '[Taio Cruz]\nOh yeah, \nThey tell me I''m a bad boy \nAll the ladies look at me and act coy \nI just like to put my hands up in the air \nI want that girl dancing over there \n\nLook at her go on the dancefloor \nShe''s amazing on the dancefloor \nWhen she moves, girl I want more \nKeep it going girl, like I got an encore \nYou got me saying: \n\nGo little bad girl, little bad girl \nGo little bad girl, little bad gir[...]'),
(77, 'http://lyrics.wikia.com/Kings_Of_Leon:Use_Somebody', 'I''ve been roaming around, always looking down and all I see\nPainted faces fill the places I can''t reach\n\nYo[...]'),
(78, 'http://lyrics.wikia.com/Philipp_Poisel:Eiserner_Steg', 'Ich atme dich ein\nund nie wieder aus.\nSchließ'' dich in mein Herz.\nLass dich nicht mehr raus.\n\nIch trage dich bei mir\nin meiner Brust.\nHätt'' alle Wege verändert.\nHätt'' ich sie vorh[...]'),
(79, 'http://lyrics.wikia.com/Kings_Of_Leon:Sex_On_Fire', 'Lay where you''re layin'', don''t make a sound\nI know they''re watchin'', they''re watchin''\nAll the commotion,[...]'),
(80, 'http://lyrics.wikia.com/index.php?title=Ilhama:Bei+Mir+Bist+Du+Scheen&amp;action=edit', 'Not found'),
(81, 'http://lyrics.wikia.com/Train:Shake_Up_Christmas', 'Ho ho ho\n\nShake up the happiness\nWake up the happiness\nShake up the happiness\nIt''s christmas time\n\nThere''s a story that i was told\nand i wanna tell the world\nbefore I get too old\nand don''t remember it\nso let''s december it\nand reassemble it (oh yeah)\n\nOnce upon a time in a town like this\nA little girl made a g[...]'),
(82, 'http://lyrics.wikia.com/Zaz:Je_Veux', 'Donnez moi une suite au Ritz, je n''en veux pas ! \n\nDes bijoux de chez CHANEL, je n''en veux pas ! \nDonnez moi une limousine, j''en ferais quoi ? papalapapapala \nOffrez moi du per[...]'),
(83, 'http://lyrics.wikia.com/Chris_Brown:Beautiful_People', 'Everywhere everywhere\nEverywhere I go\nEverywhere that i''ve been\nThe only thing I see is\nIs beautiful people\nBeautiful people\nBeautiful people\nBeautiful people\n\nDon''t you know don''t you know\nYou''re beautiful don''t y[...]'),
(84, 'http://lyrics.wikia.com/index.php?title=DJ_%C3%96tzi:I+Sing+A+Liad+F%C3%83%C2%BCr+Dich&amp;action=edit', 'Not found');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `price`
--

CREATE TABLE IF NOT EXISTS `price` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `songID` int(11) NOT NULL,
  `provider` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `value` float NOT NULL,
  `currency` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `offerUrl` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `songID` (`songID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=417 ;

--
-- Daten für Tabelle `price`
--

INSERT INTO `price` (`id`, `songID`, `provider`, `value`, `currency`, `offerUrl`) VALUES
(190, 1, 'Amazon', 0.99, '€', 'http://www.amazon.de/Video-Games/dp/B006AVS5K0%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB006AVS5K0'),
(191, 1, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/video-games-performance-edit/id477750462?uo=4'),
(192, 1, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/lana-del-rey/video-games-1/01-Video-Games/?partner=2894'),
(193, 2, 'Amazon', 0.99, '€', 'http://www.amazon.de/Hangover-Explicit/dp/B005VYI5CK%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005VYI5CK'),
(194, 2, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/taio-cruz-flo-rida/hangover/01-Hangover/?partner=2894'),
(195, 3, 'Amazon', 0.84, '€', 'http://www.amazon.de/Found-Rihanna-Calvin-Harris-Remake/dp/B005RGU90I%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005RGU90I'),
(196, 3, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/we-found-love-feat.-calvin/id470829924?i=470829925&uo=4'),
(197, 3, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/rihanna/we-found-love-1/01-We-Found-Love/?partner=2894'),
(198, 5, 'Amazon', 0.98, '€', 'http://www.amazon.de/Good-Feeling-Jaywalker-Remix/dp/B0061SISI6%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB0061SISI6'),
(199, 5, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/good-feeling/id477068524?i=477068525&uo=4'),
(200, 5, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/flo-rida/good-feeling-1/01-Good-Feeling/?partner=2894'),
(201, 6, 'Amazon', 0.99, '€', 'http://www.amazon.de/Bridge-Of-Light/dp/B006CSINR6%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB006CSINR6'),
(202, 6, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/bridge-of-light/id482884636?i=482884637&uo=4'),
(203, 6, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/pink/bridge-of-light-1/01-Bridge-Of-Light/?partner=2894'),
(204, 7, 'Amazon', 0.98, '€', 'http://www.amazon.de/Cello-Feat-Clueso-Unplugged-Atmo-Version/dp/B0060LFZEO%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB0060LFZEO'),
(205, 7, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/cello-feat.-clueso/id468640963?i=468640985&uo=4'),
(206, 7, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/udo-lindenberg-(2)/cello-feat-clueso-1/01-Cello-(feat-Clueso)-[MTV-Unplugged-Radio-Atmo-Version]/?partner=2894'),
(207, 8, 'Amazon', 0.99, '€', 'http://www.amazon.de/Im-Here/dp/B006JOYI8G%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB006JOYI8G'),
(208, 8, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/im-here/id485298186?i=485298187&uo=4'),
(209, 9, 'Amazon', 0.99, '€', 'http://www.amazon.de/Levels-Radio-Edit/dp/B0060LHSKI%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB0060LHSKI'),
(210, 9, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/levels-original-version/id476026646?i=476026648&uo=4'),
(211, 9, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/avicii/levels-1/01-Levels/?partner=2894'),
(212, 10, 'Amazon', 0.99, '€', 'http://www.amazon.de/New-Age/dp/B005HAFEFY%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005HAFEFY'),
(213, 10, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/new-age/id458051930?uo=4'),
(214, 10, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/marlon-roudette/new-age/01-New-Age/?partner=2894'),
(215, 11, 'Amazon', 0.98, '€', 'http://www.amazon.de/It-Will-Rain/dp/B0062NYGFO%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB0062NYGFO'),
(216, 11, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/it-will-rain/id467980710?i=467980717&uo=4'),
(217, 11, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/bruno-mars/it-will-rain/01-It-Will-Rain/?partner=2894'),
(218, 12, 'Amazon', 0.99, '€', 'http://www.amazon.de/Pumped-Up-Kicks/dp/B005519I98%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005519I98'),
(219, 12, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/pumped-up-kicks/id426402812?i=426402831&uo=4'),
(220, 12, '7Digital', 1.29, '€', 'http://de.7digital.com/artists/foster-the-people/pumped-up-kicks/01-Pumped-Up-Kicks/?partner=2894'),
(221, 13, 'Amazon', 0.84, '€', 'http://www.amazon.de/Originally-Performed-Pitbull-Feat-Anthony/dp/B005NMN1X8%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005NMN1X8'),
(222, 13, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/rain-over-me-feat.-marc-anthony/id442733723?i=442733728&uo=4'),
(223, 13, '7Digital', 1.29, '€', 'http://de.7digital.com/artists/pitbull-featuring-marc-anthony/rain-over-me-1/01-Rain-Over-Me/?partner=2894'),
(224, 14, 'Amazon', 0.84, '€', 'http://www.amazon.de/Moves-Jagger-feat-Christina-Aguilera/dp/B005EQ75A8%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005EQ75A8'),
(225, 14, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/moves-like-jagger-feat.-christina/id445828194?i=445828290&uo=4'),
(226, 14, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/maroon-5/moves-like-jagger/01-Moves-Like-Jagger/?partner=2894'),
(227, 15, 'Amazon', 0.99, '€', 'http://www.amazon.de/Sexy-And-I-Know-It/dp/B005BVQM2S%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005BVQM2S'),
(228, 15, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/sexy-and-i-know-it/id467064120?uo=4'),
(229, 15, '7Digital', 1.29, '€', 'http://de.7digital.com/artists/lmfao/sexy-and-i-know-it/01-Sexy-And-I-Know-It/?partner=2894'),
(230, 16, 'Amazon', 0.98, '€', 'http://www.amazon.de/When-We-Stand-Together/dp/B0064XRB72%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB0064XRB72'),
(231, 16, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/when-we-stand-together/id467140579?i=467140600&uo=4'),
(232, 17, 'Amazon', 0.99, '€', 'http://www.amazon.de/Without-Feat-Usher-Radio-Edit/dp/B005VUL990%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005VUL990'),
(233, 17, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/without-you-feat.-usher/id457937190?i=457937230&uo=4'),
(234, 17, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/david-guetta/without-you-feat-usher-remixes/01-Without-You-(feat-Usher)-[Extended]/?partner=2894'),
(235, 18, 'Amazon', 0.99, '€', 'http://www.amazon.de/Jar-Of-Hearts/dp/B0068JEZ26%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB0068JEZ26'),
(236, 18, 'iTunes', 0.99, '€', 'http://itunes.apple.com/de/album/jar-of-hearts/id384246334?i=384246369&uo=4'),
(237, 18, '7Digital', 1.29, '€', 'http://de.7digital.com/artists/christina-perri/jar-of-hearts/01-jar-of-hearts/?partner=2894'),
(238, 19, 'Amazon', 0.84, '€', 'http://www.amazon.de/Got-2-Luv-You/dp/B0067KAYNK%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB0067KAYNK'),
(239, 19, 'iTunes', 0.99, '€', 'http://itunes.apple.com/de/album/got-2-luv-u-got-to-love-you/id484358673?i=484359255&uo=4'),
(240, 20, 'Amazon', 0.99, '€', 'http://www.amazon.de/Marry-The-Night/dp/B0051H08VS%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB0051H08VS'),
(241, 20, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/marry-the-night/id438662372?i=438662376&uo=4'),
(242, 21, 'Amazon', 0.99, '€', 'http://www.amazon.de/Worte-Meine-Sprache-Single-Version/dp/B005NIYKDM%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005NIYKDM'),
(243, 21, 'iTunes', 2.49, '€', 'http://itunes.apple.com/de/music-video/nur-noch-kurz-die-welt-retten/id439232830?uo=4'),
(244, 22, 'Amazon', 0.99, '€', 'http://www.amazon.de/Nur-Noch-Kurz-Welt-Retten/dp/B00557WP7O%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB00557WP7O'),
(245, 22, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/nur-noch-kurz-die-welt-retten/id433608961?i=433608982&uo=4'),
(246, 22, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/tim-bendzko/nur-noch-kurz-die-welt-retten/01-Nur-noch-kurz-die-Welt-retten/?partner=2894'),
(247, 23, 'Amazon', 0.99, '€', 'http://www.amazon.de/Paradise/dp/B005XK5YSK%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005XK5YSK'),
(248, 23, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/paradise/id471339278?i=471339288&uo=4'),
(249, 23, '7Digital', 1.29, '€', 'http://de.7digital.com/artists/coldplay/paradise/01-Paradise/?partner=2894'),
(250, 24, 'Amazon', 0.98, '€', 'http://www.amazon.de/It-Girl/dp/B0064XSDBA%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB0064XSDBA'),
(251, 24, 'iTunes', 2.49, '€', 'http://itunes.apple.com/de/music-video/it-girl/id463101879?uo=4'),
(252, 24, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/jason-derulo/it-girl-3/01-It-Girl/?partner=2894'),
(253, 25, 'Amazon', 0.89, '€', 'http://www.amazon.de/Turn-This-Club-Around-Video/dp/B006A469NC%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB006A469NC'),
(254, 25, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/turn-this-club-around-feat./id472339113?uo=4'),
(255, 25, '7Digital', 1.29, '€', 'http://de.7digital.com/artists/r-i-o-feat-u-jean/turn-this-club-around/01-Turn-This-Club-Around/?partner=2894'),
(256, 26, 'Amazon', 0.99, '€', 'http://www.amazon.de/Echt/dp/B005I6CIYC%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005I6CIYC'),
(257, 26, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/echt/id458043012?uo=4'),
(258, 27, 'Amazon', 0.99, '€', 'http://www.amazon.de/Last-Christmas-Single-Version/dp/B001VFTJKA%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB001VFTJKA'),
(259, 27, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/last-christmas/id404139465?uo=4'),
(260, 27, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/wham/last-christmas/01-Last-Christmas/?partner=2894'),
(261, 28, 'Amazon', 0.99, '€', 'http://www.amazon.de/Domino/dp/B0062B9B6A%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB0062B9B6A'),
(262, 28, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/domino-live-montage-2011-live/id472634016?uo=4'),
(263, 28, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/jessie-j/domino-1/01-Domino/?partner=2894'),
(264, 29, 'Amazon', 0.99, '€', 'http://www.amazon.de/Dont-Gimme-That/dp/B0063WO208%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB0063WO208'),
(265, 29, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/dont-gimme-that/id480112621?uo=4'),
(266, 30, 'Amazon', 0.77, '€', 'http://www.amazon.de/Lmfao-Anthem-Lauren-Bennett-Goonrock/dp/B005VA9NWA%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005VA9NWA'),
(267, 30, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/party-rock-anthem-feat.-lauren/id417447914?i=417447921&uo=4'),
(268, 30, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/lmfao/party-rock-anthem/01-Party-Rock-Anthem/?partner=2894'),
(269, 31, 'Amazon', 0.99, '€', 'http://www.amazon.de/Erwachsen-Sein/dp/B0064XRF0K%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB0064XRF0K'),
(270, 31, 'iTunes', 0.99, '€', 'http://itunes.apple.com/de/album/erwachsen-sein-feat.-peter/id467405448?i=467405558&uo=4'),
(271, 31, '7Digital', 1.29, '€', 'http://de.7digital.com/artists/23-feat-peter-maffay/erwachsen-sein/01-Erwachsen-sein/?partner=2894'),
(272, 32, 'Amazon', 0.99, '€', 'http://www.amazon.de/Ch%C3%A9rie-Antoine-Mark-2k12-Radio/dp/B005XGXPNK%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005XGXPNK'),
(273, 32, '7Digital', 0.99, '€', 'http://de.7digital.com/artists/dj-antoine/ma-cherie/01-Ma-Ch%c3%a9rie/?partner=2894'),
(274, 33, 'Amazon', 0.99, '€', 'http://www.amazon.de/Called-Out-In-The-Dark/dp/B00640U1N6%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB00640U1N6'),
(275, 33, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/called-out-in-the-dark/id458578212?uo=4'),
(276, 33, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/snow-patrol/called-out-in-the-dark-1/01-Called-Out-In-The-Dark/?partner=2894'),
(277, 34, 'Amazon', 0.99, '€', 'http://www.amazon.de/The-A-Team/dp/B005YDU9AY%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005YDU9AY'),
(278, 34, 'iTunes', 0.99, '€', 'http://itunes.apple.com/de/album/the-a-team/id466851139?i=466851320&uo=4'),
(279, 34, '7Digital', 1.29, '€', 'http://de.7digital.com/artists/ed-sheeran/the-a-team/01-The-A-Team/?partner=2894'),
(280, 35, 'Amazon', 0.99, '€', 'http://www.amazon.de/The-One-That-Got-Away/dp/B003Z6F3G2%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB003Z6F3G2'),
(281, 35, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/the-one-that-got-away/id386374788?i=386375017&uo=4'),
(282, 35, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/katy-perry/the-one-that-got-away-remix-bundle/01-The-One-That-Got-Away-(7th-Heaven-Club-Mix)/?partner=2894'),
(283, 36, 'Amazon', 0.77, '€', 'http://www.amazon.de/Whatever-Karaoke-Version-Rowland-Featuring/dp/B006KFLBFM%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB006KFLBFM'),
(284, 36, 'iTunes', 0.99, '€', 'http://itunes.apple.com/de/album/down-for-whatever-karaoke/id484494585?i=484495031&uo=4'),
(285, 36, '7Digital', 1.29, '€', 'http://de.7digital.com/artists/kelly-rowland/down-for-whatever/01-Down-For-Whatever/?partner=2894'),
(286, 37, 'Amazon', 0.99, '€', 'http://www.amazon.de/All-Want-Christmas-Original-Version/dp/B001UHL1QY%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB001UHL1QY'),
(287, 37, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/all-i-want-for-christmas-is/id485329202?uo=4'),
(288, 37, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/mariah-carey/all-i-want-for-christmas-is-you-extra-festive/01-All-I-Want-For-Christmas-Is-You/?partner=2894'),
(289, 38, 'Amazon', 0.99, '€', 'http://www.amazon.de/River-Flows-In-You/dp/B00635OH5U%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB00635OH5U'),
(290, 38, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/river-flows-in-you-live-at/id478834709?uo=4'),
(291, 38, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/yiruma/river-flows-in-you-1/01-River-Flows-In-You/?partner=2894'),
(292, 39, 'Amazon', 0.99, '€', 'http://www.amazon.de/Goin-To-L-A/dp/B005Z8LNO4%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005Z8LNO4'),
(293, 39, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/goin-to-l.a./id475700034?uo=4'),
(294, 40, 'Amazon', 0.99, '€', 'http://www.amazon.de/Danza-Kuduro-Sagi-Abitbul-Remix/dp/B005HK6JZ8%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005HK6JZ8'),
(295, 40, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/danza-kuduro-throw-your-hands/id458314141?uo=4'),
(296, 40, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/lucenzo-don-omar/danza-kuduro/01-Danza-Kuduro/?partner=2894'),
(297, 41, 'Amazon', 0.99, '€', 'http://www.amazon.de/U-Know-It-Aint-Love/dp/B006CC5P4G%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB006CC5P4G'),
(298, 41, '7Digital', 0.99, '€', 'http://de.7digital.com/artists/radio-slave/sex-trax/01-RJ/?partner=2894'),
(299, 42, 'Amazon', 0.99, '€', 'http://www.amazon.de/Wir-Sind-Am-Leben/dp/B005M5PV7U%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005M5PV7U'),
(300, 42, 'iTunes', 2.49, '€', 'http://itunes.apple.com/de/music-video/wir-sind-am-leben/id459950830?uo=4'),
(301, 42, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/rosenstolz/wir-sind-am-leben/01-Wir-sind-am-Leben/?partner=2894'),
(302, 43, 'Amazon', 0.99, '€', 'http://www.amazon.de/Ring-The-Bell/dp/B0066QDQRG%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB0066QDQRG'),
(303, 43, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/ring-the-bell/id485270933?uo=4'),
(304, 44, 'Amazon', 0.99, '€', 'http://www.amazon.de/I-Wont-Let-You-Go/dp/B005KGQ1TS%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005KGQ1TS'),
(305, 44, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/i-wont-let-you-go/id455205178?uo=4'),
(306, 44, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/james-morrison/i-wont-let-you-go-1/01-I-Wont-Let-You-Go/?partner=2894'),
(307, 45, 'Amazon', 0.99, '€', 'http://www.amazon.de/Wonderful-Dream-Holidays-Coming-Version/dp/B001SWK4JG%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB001SWK4JG'),
(308, 45, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/wonderful-dream-holidays-are/id267388458?i=267388474&uo=4'),
(309, 45, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/melanie-thornton/wonderful-dream-holidays-are-coming/01-Wonderful-Dream-(Holidays-Are-Coming)/?partner=2894'),
(310, 46, 'Amazon', 0.99, '€', 'http://www.amazon.de/Welcome-Tropez-Antoine-Radio-Explicit/dp/B005FQHNA4%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005FQHNA4'),
(311, 46, 'iTunes', 0.99, '€', 'http://itunes.apple.com/de/album/welcome-to-st.-tropez-dj-antoine/id420914946?i=420914955&uo=4'),
(312, 46, '7Digital', 1.29, '€', 'http://de.7digital.com/artists/dj-antoine-vs-timati-feat-kalenna/welcome-to-st-tropez-1/01-Welcome-To-St-Tropez/?partner=2894'),
(313, 47, 'Amazon', 0.99, '€', 'http://www.amazon.de/Hungry-Eyes/dp/B0063XEVVM%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB0063XEVVM'),
(314, 47, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/hungry-eyes/id479266827?uo=4'),
(315, 47, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/culcha-candela/hungry-eyes/01-Hungry-Eyes/?partner=2894'),
(316, 48, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/heroes-helden/id481298308?uo=4'),
(317, 49, 'Amazon', 0.99, '€', 'http://www.amazon.de/Animal-Extended-Mix/dp/B006FOUEH4%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB006FOUEH4'),
(318, 49, 'iTunes', 0.99, '€', 'http://itunes.apple.com/de/album/animal-video-edit-feat.-u-jean/id480211093?i=480211094&uo=4'),
(319, 50, 'Amazon', 0.69, '€', 'http://www.amazon.de/Mr-Saxobeat-Extended-Version/dp/B004XDFH1W%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB004XDFH1W'),
(320, 50, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/mr.-saxobeat/id433375808?uo=4'),
(321, 50, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/alexandra-stan/mr-saxobeat-7/01-Mr-Saxobeat/?partner=2894'),
(322, 51, 'Amazon', 0.99, '€', 'http://www.amazon.de/Mr-Know-It-All/dp/B005OTRI8Y%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005OTRI8Y'),
(323, 51, 'iTunes', 0.99, '€', 'http://itunes.apple.com/de/album/mr.-know-it-all/id464532842?i=464532942&uo=4'),
(324, 51, '7Digital', 1.29, '€', 'http://de.7digital.com/artists/kelly-clarkson/mr-know-it-all/01-Mr-Know-It-All/?partner=2894'),
(325, 52, 'Amazon', 0.99, '€', 'http://www.amazon.de/I-Sing-Liad-F%C3%BCr/dp/B005CDLG2G%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005CDLG2G'),
(326, 52, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/i-sing-a-liad-fur-di/id467587133?uo=4'),
(327, 52, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/andreas-gabalier/i-sing-a-liad-fur-di/01-I-sing-a-Liad-f%c3%bcr-di/?partner=2894'),
(328, 53, 'Amazon', 0.89, '€', 'http://www.amazon.de/One-Night-Ibiza-Extended-Mix/dp/B005JDEBK8%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005JDEBK8'),
(329, 53, 'iTunes', 0.99, '€', 'http://itunes.apple.com/de/album/one-night-in-ibiza-radio-mix/id458355241?i=458355242&uo=4'),
(330, 53, '7Digital', 1.29, '€', 'http://de.7digital.com/artists/mike-candys-and-evelyn-feat-patrick-miller-1/one-night-in-ibiza/01-One-Night-in-Ibiza/?partner=2894'),
(331, 54, 'Amazon', 0.99, '€', 'http://www.amazon.de/Day-Dreaming-David-May-Extended/dp/B006BEZFT0%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB006BEZFT0'),
(332, 54, '7Digital', 0.99, '€', 'http://de.7digital.com/artists/the-redd/get-naked/01-Get-Naked/?partner=2894'),
(333, 55, 'Amazon', 0.99, '€', 'http://www.amazon.de/Loca-People-What-Explicit/dp/B005GT0ZRI%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005GT0ZRI'),
(334, 55, 'iTunes', 2.49, '€', 'http://itunes.apple.com/de/music-video/loca-people-what-the-f-k!/id454143871?uo=4'),
(335, 55, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/sak-noel/loca-people-4/01-Loca-People-(What-the-F-k-)/?partner=2894'),
(336, 56, 'Amazon', 0.77, '€', 'http://www.amazon.de/Jennifer-Lopez-Floor-feat-Pitbull/dp/B004QQZUJA%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB004QQZUJA'),
(337, 56, 'iTunes', 2.49, '€', 'http://itunes.apple.com/de/music-video/on-the-floor/id424397905?uo=4'),
(338, 56, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/jennifer-lopez/on-the-floor/01-On-The-Floor/?partner=2894'),
(339, 57, 'Amazon', 0.99, '€', 'http://www.amazon.de/Mistletoe/dp/B005ZJXN78%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005ZJXN78'),
(340, 57, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/mistletoe/id475410465?i=475411069&uo=4'),
(341, 57, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/justin-bieber/mistletoe/01-Mistletoe/?partner=2894'),
(342, 58, 'Amazon', 0.99, '€', 'http://www.amazon.de/Give-Everything-Bingo-Players-Remix/dp/B0053HA01O%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB0053HA01O'),
(343, 58, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/give-me-everything-feat.-ne/id428086874?i=428086879&uo=4'),
(344, 58, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/pitbull/give-me-everything/01-Give-Me-Everything/?partner=2894'),
(345, 59, 'Amazon', 0.99, '€', 'http://www.amazon.de/Hollywood-Hills/dp/B004P4UHFA%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB004P4UHFA'),
(346, 59, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/hollywood-hills/id413834115?i=413834119&uo=4'),
(347, 59, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/sunrise-avenue/hollywood-hills-1/01-Hollywood-Hills/?partner=2894'),
(348, 60, 'Amazon', 0.99, '€', 'http://www.amazon.de/Cant-Stand-The-Silence/dp/B005M9GZ3U%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005M9GZ3U'),
(349, 60, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/cant-stand-the-silence/id462777178?uo=4'),
(350, 60, '7Digital', 1.29, '€', 'http://de.7digital.com/artists/rea-garvey/cant-stand-the-silence/01-Cant-Stand-The-Silence/?partner=2894'),
(351, 61, 'Amazon', 0.99, '€', 'http://www.amazon.de/A-Night-Like-This-Instrumental/dp/B004NZOXWE%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB004NZOXWE'),
(352, 61, 'iTunes', 2.49, '€', 'http://itunes.apple.com/de/music-video/a-night-like-this/id417394319?uo=4'),
(353, 61, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/caro-emerald/a-night-like-this-3/01-A-Night-Like-This/?partner=2894'),
(354, 62, 'Amazon', 0.99, '€', 'http://www.amazon.de/K%C3%BCss-Mich-Halt-Radio-Version/dp/B0035GVW8U%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB0035GVW8U'),
(355, 62, 'iTunes', 2.49, '€', 'http://itunes.apple.com/de/music-video/kuss-mich-halt-mich-lieb-mich/id395068994?uo=4'),
(356, 63, 'Amazon', 0.99, '€', 'http://www.amazon.de/Still/dp/B004P3GABQ%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB004P3GABQ'),
(357, 63, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/still-videoclip-videoclip/id420899296?uo=4'),
(358, 63, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/jupiter-jones/still-2/01-Still/?partner=2894'),
(359, 64, 'Amazon', 0.99, '€', 'http://www.amazon.de/Sweat-Snoop-David-Guetta-Explicit/dp/B004TJ8TJM%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB004TJ8TJM'),
(360, 64, 'iTunes', 0.69, '€', 'http://itunes.apple.com/de/album/sweat-snoop-dogg-vs.-david/id424187513?i=424187515&uo=4'),
(361, 64, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/snoop-dogg/sweat-david-guetta-remix/01-Sweat-(Snoop-Dogg-vs-David-Guetta)-[Remix]/?partner=2894'),
(362, 65, 'Amazon', 0.99, '€', 'http://www.amazon.de/Cest-Bleu/dp/B005QH2TSS%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005QH2TSS'),
(363, 65, 'iTunes', 0.69, '€', 'http://itunes.apple.com/de/album/cest-bleu-radio-edit/id482124881?i=482124885&uo=4'),
(364, 65, '7Digital', 1.29, '€', 'http://de.7digital.com/artists/scooter/ramp-the-logical-song/01-The-Logical-Song/?partner=2894'),
(365, 67, 'Amazon', 0.99, '€', 'http://www.amazon.de/Do-They-Know-Its-Christmas/dp/B001SPQ7TY%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB001SPQ7TY'),
(366, 67, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/do-they-know-its-christmas/id30410033?i=30410035&uo=4'),
(367, 68, 'Amazon', 0.99, '€', 'http://www.amazon.de/Changed-Way-You-Kiss-Extended/dp/B005HY6HEM%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005HY6HEM'),
(368, 68, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/changed-the-way-you-kiss-me/id480191891?uo=4'),
(369, 68, '7Digital', 1.29, '€', 'http://de.7digital.com/artists/example/changed-the-way-you-kiss-me-3/01-Changed-the-Way-You-Kiss-Me/?partner=2894'),
(370, 69, 'Amazon', 0.99, '€', 'http://www.amazon.de/The-Edge-Of-Glory/dp/B0051KMN5E%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB0051KMN5E'),
(371, 69, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/the-edge-of-glory/id438662372?i=438662420&uo=4'),
(372, 69, '7Digital', 1.29, '€', 'http://de.7digital.com/artists/lady-gaga/the-edge-of-glory-1/01-The-Edge-Of-Glory/?partner=2894'),
(373, 70, 'Amazon', 0.98, '€', 'http://www.amazon.de/Nicht-Reparieren-Feat-Unplugged-Version/dp/B005KF5UBE%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005KF5UBE'),
(374, 70, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/ein-herz-kann-man-nicht-reparieren/id468640963?i=468640976&uo=4'),
(375, 70, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/udo-lindenberg-(2)/ein-herz-kann-man-nicht-reparieren/01-Ein-Herz-kann-man-nicht-reparieren-(feat-Inga-Humpe)-[MTV-Unplugged-Radio-Version]/?partner=2894'),
(376, 71, 'Amazon', 0.98, '€', 'http://www.amazon.de/Grenade/dp/B004KTFRNW%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB004KTFRNW'),
(377, 71, 'iTunes', 2.49, '€', 'http://itunes.apple.com/de/music-video/grenade/id409143502?uo=4'),
(378, 71, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/bruno-mars/grenade-2/01-Grenade/?partner=2894'),
(379, 72, 'Amazon', 0.84, '€', 'http://www.amazon.de/Aura/dp/B0065JZ0GE%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB0065JZ0GE'),
(380, 72, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/aura/id481890881?uo=4'),
(381, 72, '7Digital', 0.99, '€', 'http://de.7digital.com/artists/kool-savas/aura/01-Aura/?partner=2894'),
(382, 73, 'Amazon', 0.99, '€', 'http://www.amazon.de/Wovon-Sollen-Wir-Tr%C3%A4umen/dp/B004TCSHJG%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB004TCSHJG'),
(383, 73, 'iTunes', 0.99, '€', 'http://itunes.apple.com/de/album/wovon-sollen-wir-traumen/id427469220?i=427469228&uo=4'),
(384, 73, '7Digital', 1.29, '€', 'http://de.7digital.com/artists/frida-gold/wovon-sollen-wir-traumen/01-Wovon-sollen-wir-tr%c3%a4umen/?partner=2894'),
(385, 74, 'Amazon', 0.77, '€', 'http://www.amazon.de/Tribute-Natalia-Will-I-Am-Performed-Nation/dp/B005DKC0VY%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005DKC0VY'),
(386, 74, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/free/id452222301?uo=4'),
(387, 74, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/natalia-kills/free-1/01-Free/?partner=2894'),
(388, 75, 'Amazon', 0.98, '€', 'http://www.amazon.de/Wonderful-Life/dp/B005OJ6QQY%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005OJ6QQY'),
(389, 75, 'iTunes', 2.49, '€', 'http://itunes.apple.com/de/music-video/molotov-wonderful-life/id466356119?uo=4'),
(390, 75, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/seeed/molotov-wonderful-life/01-Molotov/?partner=2894'),
(391, 76, 'Amazon', 0.99, '€', 'http://www.amazon.de/Little-Girl-Feat-Ludacris-Explicit/dp/B005ILZG7I%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005ILZG7I'),
(392, 76, 'iTunes', 2.49, '€', 'http://itunes.apple.com/de/music-video/little-bad-girl-feat.taio/id451165536?uo=4'),
(393, 76, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/david-guetta/little-bad-girl-feat-taio-cruz-and-ludacris/01-Little-Bad-Girl-(feat-Taio-Cruz-and-Ludacris)/?partner=2894'),
(394, 77, 'Amazon', 0.99, '€', 'http://www.amazon.de/Use-Somebody/dp/B001V82RIS%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB001V82RIS'),
(395, 77, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/use-somebody/id289072736?i=289072756&uo=4'),
(396, 77, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/kings-of-leon/use-somebody-1/01-Use-Somebody/?partner=2894'),
(397, 78, 'Amazon', 0.99, '€', 'http://www.amazon.de/Eiserner-Steg-Klavier-Version/dp/B005M77NPG%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005M77NPG'),
(398, 78, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/eiserner-steg-klavier-version/id464242079?uo=4'),
(399, 78, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/philipp-poisel/eiserner-steg/01-Eiserner-Steg/?partner=2894'),
(400, 79, 'Amazon', 0.99, '€', 'http://www.amazon.de/Sex-On-Fire/dp/B001V6PTZ8%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB001V6PTZ8'),
(401, 79, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/sex-on-fire/id291106881?uo=4'),
(402, 79, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/kings-of-leon/sex-on-fire/01-Sex-On-Fire/?partner=2894'),
(403, 80, 'Amazon', 0.99, '€', 'http://www.amazon.de/Bei-Bist-Scheen-Single-Edit/dp/B005ZHVSBS%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005ZHVSBS'),
(404, 80, 'iTunes', 0.99, '€', 'http://itunes.apple.com/de/album/bei-mir-bist-du-scheen-single/id476299176?i=476299181&uo=4'),
(405, 81, 'Amazon', 0.99, '€', 'http://www.amazon.de/Shake-Christmas-Coke-Xmas-Anthem/dp/B004BH7BLO%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB004BH7BLO'),
(406, 81, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/shake-up-christmas/id407477437?uo=4'),
(407, 81, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/train/shake-up-christmas/01-Shake-Up-Christmas/?partner=2894'),
(408, 82, 'Amazon', 0.99, '€', 'http://www.amazon.de/Je-Veux/dp/B0040D3MJ4%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB0040D3MJ4'),
(409, 82, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/je-veux/id395003811?uo=4'),
(410, 82, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/zaz/je-veux-2/01-Je-Veux/?partner=2894'),
(411, 83, 'Amazon', 0.84, '€', 'http://www.amazon.de/Beautiful-People-Chris-Benassi-Remake/dp/B004TPMZC8%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB004TPMZC8'),
(412, 83, 'iTunes', 1.29, '€', 'http://itunes.apple.com/de/album/beautiful-people-uk-radio/id438409748?i=438409790&uo=4'),
(413, 83, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/chris-brown-(2)/beautiful-people-2/01-Beautiful-People/?partner=2894'),
(414, 84, 'Amazon', 0.99, '€', 'http://www.amazon.de/Sing-Liad-Dich-Single-Version/dp/B005I78I5Y%3FSubscriptionId%3DAKIAJRWULOQJOTTEI66A%26tag%3DAKIAJRWULOQJOTTEI66A%26linkCode%3Dsp1%26camp%3D2025%26creative%3D165953%26creativeASIN%3DB005I78I5Y'),
(415, 84, 'iTunes', 1.79, '€', 'http://itunes.apple.com/de/music-video/i-sing-a-liad-fur-dich/id464770835?uo=4'),
(416, 84, '7Digital', 1.49, '€', 'http://de.7digital.com/artists/dj-ötzi/i-sing-a-liad-fur-dich-2/01-I-Sing-A-Liad-F%c3%bcr-Dich/?partner=2894');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `rating`
--

CREATE TABLE IF NOT EXISTS `rating` (
  `userID` int(11) NOT NULL,
  `songID` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  PRIMARY KEY (`userID`,`songID`),
  KEY `songID` (`songID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Daten für Tabelle `rating`
--


--
-- Trigger `rating`
--
DROP TRIGGER IF EXISTS `ratingInsert`;
DELIMITER //
CREATE TRIGGER `ratingInsert` AFTER INSERT ON `rating`
 FOR EACH ROW begin
	update song set voteTotal = voteTotal + new.rating, voteCount = voteCount + 1 where song.id = new.songID;
end
//
DELIMITER ;
DROP TRIGGER IF EXISTS `ratingUpdate`;
DELIMITER //
CREATE TRIGGER `ratingUpdate` AFTER UPDATE ON `rating`
 FOR EACH ROW begin
	update song set voteTotal = voteTotal - old.rating, voteCount = voteCount - 1 where song.id = old.songID;
	update song set voteTotal = voteTotal + new.rating, voteCount = voteCount + 1 where song.id = new.songID;
end
//
DELIMITER ;
DROP TRIGGER IF EXISTS `ratingDelete`;
DELIMITER //
CREATE TRIGGER `ratingDelete` AFTER DELETE ON `rating`
 FOR EACH ROW begin
	update song set voteTotal = voteTotal - old.rating, voteCount = voteCount - 1 where song.id = old.songID;
end
//
DELIMITER ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=85 ;

--
-- Daten für Tabelle `song`
--

INSERT INTO `song` (`id`, `interpreter`, `title`, `date`, `tracklength`, `video`, `rating`, `voteCount`, `voteTotal`, `picture`) VALUES
(1, 'Lana Del Rey', 'Video Games', '2011-12-17', 290, 'http://www.myvideo.de/movie/8299299', 0, 0, 0, 'http://3.bp.blogspot.com/-pEz5kYSRaWs/Tm2O1kgzvaI/AAAAAAAAAIo/Rgvlc--jJPw/s1600/lana_pack_shot_small.jpg'),
(2, 'Taio Cruz featuring Flo Rida', 'Hangover', '2011-12-17', 290, 'http://www.myvideo.de/movie/8314947', 0, 0, 0, 'http://3.bp.blogspot.com/-CLWoiMTpz8M/To-HAMJaDgI/AAAAAAAABKM/lG23nJ-U_Ss/s1600/Taio%2BCruz%2B-%2BHangover%2Bfeaturing%2BFlo%2BRida%2B-%2BSingle%2BiTunes%2Bcover%2B600x600.jpg'),
(3, 'Rihanna feat. Calvin Harris', 'We Found Love', '2011-12-17', 276, 'http://www.myvideo.de/movie/8301859', 0, 0, 0, 'http://tracksnob.com/instrumentals/wp-content/uploads/2011/10/rihanna-calvin-harris-we-found-love-instrumental.jpg'),
(4, 'Gotye featuring Kimbra', 'Somebody That I Used To Know', '2011-12-17', 244, 'http://www.myvideo.de/movie/8326145', 0, 0, 0, 'http://www.theburningear.com/media/2011/07/Gotye-Somebody-That-I-Used-To-Know-300x300.jpg'),
(5, 'Flo Rida', 'Good Feeling ', '2011-12-17', 258, 'http://www.myvideo.de/movie/8317540', 0, 0, 0, 'http://s3.noelshack.com/uploads/images/1446920473482_flo_rida__good_feeling_levels_version_cover.jpg'),
(6, 'P!NK', 'Bridge Of Light', '2011-12-17', 174, 'http://www.myvideo.de/movie/8364968', 0, 0, 0, 'http://lp.sonymusic.de/images/pink/bridge_of_light_cover.jpg'),
(7, 'Udo Lindenberg', 'Cello ', '2011-12-17', 217, 'http://www.myvideo.de/movie/8296234', 0, 0, 0, 'http://www.udo-lindenberg.de/sixcms/media.php/332/thumbnails/belcantocover.jpg.46910.jpg'),
(8, 'David Pfeffer', 'I´m Here', '2011-12-17', 233, 'http://www.myvideo.de/movie/8371997', 0, 0, 0, 'http://iplus4u.com/wp-content/uploads/Im-Here-Single.png'),
(9, 'Avicii', 'Levels', '2011-12-17', 199, 'http://www.myvideo.de/movie/8362276', 0, 0, 0, 'http://www.electricbeatsyndicate.com/wp-content/uploads/2011/07/AVICII-LEVELS.jpg'),
(10, 'Marlon Roudette', 'New Age ', '2011-12-17', 191, 'http://www.myvideo.de/movie/8238018', 0, 0, 0, 'http://www.bbradio.de/radio/musik/songs/2011/08/Marlon-Roudette_New-Age-Cover.jpg'),
(11, 'Bruno Mars', 'It Will Rain', '2011-12-17', 258, 'http://www.myvideo.de/movie/8344476', 0, 0, 0, 'http://1.bp.blogspot.com/-2lxQM_uE6Iw/TnxCUdj9O6I/AAAAAAAAA1Y/2pDV7GhDcnk/s640/ItWillRain.jpg'),
(12, 'Foster The People', 'Pumped Up Kicks', '2011-12-17', 241, 'http://www.myvideo.de/movie/8167247', 0, 0, 0, 'http://1.bp.blogspot.com/-Sf64UBpVtK8/TZGEZU1wu7I/AAAAAAAAAZ0/Y3n0pV2nGgY/s1600/Foster%25252Bthe%25252BPeople%25252BRemember%25252BWho%25252BYou%25252BAre.jpg'),
(13, 'Pitbull feat. Marc Anthony', 'Rain Over Me', '2011-12-17', 233, 'http://www.myvideo.de/movie/8214647', 0, 0, 0, 'http://1.bp.blogspot.com/-qSeE0PcYizk/TinH-j1PrmI/AAAAAAAABLE/vTFqzVNYfp4/s1600/rain-over-me.jpg'),
(14, 'Maroon 5 feat. Christina Aguilera', 'Moves Like Jagger', '2011-12-17', 281, 'http://www.myvideo.de/movie/8231264', 0, 0, 0, 'http://wac.450f.edgecastcdn.net/80450F/popcrush.com/files/2011/06/Moves-Like-Jagger.jpg'),
(15, 'LMFAO', 'Sexy And I Know It', '2011-12-17', 205, 'http://www.myvideo.de/movie/8269163', 0, 0, 0, 'http://lacoquillita.com/v3/wp-content/uploads/2011/09/LMFAO-Sexy-and-I-Know-It.png'),
(16, 'Nickelback', 'When We Stand Together ', '2011-12-17', 194, 'http://www.myvideo.de/movie/8328930', 0, 0, 0, 'http://www.4ump3.com/wp-content/uploads/2011/11/Nickelback-When-We-Stand-Together.jpg'),
(17, 'David Guetta feat. Usher', 'Without You ', '2011-12-17', 210, 'http://www.myvideo.de/movie/8294051', 0, 0, 0, 'http://www.chartstats.com/images/artwork/44568.jpg'),
(18, 'Christina Perri', 'Jar Of Hearts', '2011-12-17', 260, 'http://www.myvideo.de/movie/8287579', 0, 0, 0, 'http://3.bp.blogspot.com/-Wy7ldvzUHrE/TlfN-5OKf-I/AAAAAAAAAj8/NSMVP6GZktU/s1600/Christina%252BPerri%252B-%252BJar%252Bof%252BHearts%252B%252528Official%252BSingle%252BCover%252529.png'),
(19, 'Sean Paul', 'Got 2 Luv You', '2011-12-17', 208, 'http://www.myvideo.de/movie/8268991', 0, 0, 0, 'http://www.thecomplexmedia.com/blog/wp-content/uploads/2011/09/Sean-Paul-Got-2-Luv-U-ft-Alexis-Jordan-Album-Cover-300x300.jpg'),
(20, 'Lady Gaga', 'Marry The Night ', '2011-12-17', 831, 'http://www.myvideo.de/movie/8364900', 0, 0, 0, 'http://chemical-magazine.com/wp-content/uploads/2011/05/marry-the-night.jpg'),
(21, 'Tim Bendzko', 'Wenn Worte meine Sprache wären', '2011-12-17', 196, 'http://www.myvideo.de/movie/8261169', 0, 0, 0, 'http://www.fan-lexikon.de/musik/tim-bendzko/bilder/l/tim-bendzko-wenn-worte-meine-sprache-waeren-album-cover-14460.jpg'),
(22, 'Tim Bendzko', 'Nur noch kurz die Welt retten ', '2011-12-17', 191, 'http://www.myvideo.de/movie/8122228', 0, 0, 0, 'http://www.fan-lexikon.de/musik/tim-bendzko/bilder/l/tim-bendzko-nur-noch-kurz-die-welt-retten-single-cover-14459.jpg'),
(23, 'Coldplay', 'Paradise', '2011-12-17', 261, 'http://www.myvideo.de/movie/8301371', 0, 0, 0, 'http://1.bp.blogspot.com/-S9fv8MNRqGs/Tmy8iXaQIZI/AAAAAAAAA3U/tW7x_v-wpvA/s1600/coldplayparadise.jpg'),
(24, 'Jason Derulo', 'It girl', '2011-12-17', 197, 'http://www.myvideo.de/movie/8237998', 0, 0, 0, 'http://27.media.tumblr.com/tumblr_lpyxzjya0T1qg8hy0o1_1313410548_cover.jpg'),
(25, 'R.I.O. feat. U-Jean', 'Turn This Club Around ', '2011-12-17', 207, 'http://www.myvideo.de/movie/8267742', 0, 0, 0, 'http://bacauhousemafia.ro/wp-content/uploads/2011/09/a105.jpg'),
(26, 'Glasperlenspiel', 'Echt', '2011-12-17', 197, 'http://www.myvideo.de/movie/8233257', 0, 0, 0, 'http://3.bp.blogspot.com/-g_FOv08-88g/Tm5ro-PWzPI/AAAAAAAAAR4/qY0mGVh9Ghc/s1600/glasperlenspiel_echt-cover_232x232.jpg'),
(27, 'Wham!', 'Last Christmas', '2011-12-17', 278, 'http://www.myvideo.de/movie/2561294', 0, 0, 0, 'http://hmusick.files.wordpress.com/2009/12/25b86db042f2daaf0dff8e17e966221c_image_document_large_featured_borderless.jpg'),
(28, 'Jessie J', 'Domino', '2011-12-17', 242, 'http://www.myvideo.de/movie/8295110', 0, 0, 0, 'http://poponandon.com/wp-content/uploads/2011/09/Jessie-J-Domino-Cover.jpg'),
(29, 'The BossHoss', 'Don''t Gimme That', '2011-12-17', 210, 'http://www.myvideo.de/movie/8303845', 0, 0, 0, 'http://img.electro-maniacs.net/51944.jpg'),
(30, 'LMFAO', 'Party Rock Anthem ', '2011-12-17', 364, 'http://www.myvideo.de/movie/8094578', 0, 0, 0, 'http://www.chartstats.com/images/artwork/42819.jpg'),
(31, '23 feat. Peter Maffay', 'Erwachsen Sein', '2011-12-17', 218, 'http://www.myvideo.de/movie/8337655', 0, 0, 0, 'http://image.viduba.com/video--23-bushido-sido-feat-peter-maffay-erwachsen-sein--QZlRxlFWwZUTGJFTXxmWONlMoVVV31TP.jpeg'),
(32, 'DJ Antoine ft. The Beat Shakers', 'Ma Chérie ', '2011-12-17', 201, 'http://www.myvideo.de/movie/8322990', 0, 0, 0, 'http://3.bp.blogspot.com/_XQlVgoUfIiM/TDvrTnSHJuI/AAAAAAAAAIs/dTs1bY-zmz0/s1600/CS1592400-02A-BIG.jpg'),
(33, 'Snow Patrol', 'Called Out In The Dark', '2011-12-17', 258, 'http://www.myvideo.de/movie/8239540', 0, 0, 0, 'http://poponandon.com/wp-content/uploads/2011/07/Snow-Patrol-Called-Out-In-The-Dark.jpg'),
(34, 'Ed Sheeran', 'The A Team', '2011-12-17', 284, 'http://www.myvideo.de/movie/8250602', 0, 0, 0, 'http://www.pyromag.com/wp-content/uploads/2011/06/Ed-Sheeran-The-A-Team.jpg'),
(35, 'Katy Perry', 'The One That Got Away', '2011-12-17', 291, 'http://www.myvideo.de/movie/8333627', 0, 0, 0, 'http://images5.fanpop.com/image/photos/25800000/The-One-That-Got-Away-Fanmade-Single-Covers-katy-perry-25860766-800-800.jpg'),
(36, 'Kelly Rowland featuring The WAV.s', 'Down For Whatever', '2011-12-17', 246, 'http://www.myvideo.de/movie/8300988', 0, 0, 0, 'http://4.bp.blogspot.com/-LgmShqAxCLs/TkAS5SB8UqI/AAAAAAAAOrY/XS71JM1bV_Y/s1600/Kelly%252BRowland%252B-%252BDown%252BFor%252BWhatever%252B%252528feat.%252BWAV.s%252529%252BLyrics.png'),
(37, 'Mariah Carey', 'All I Want For Christmas Is You', '2011-12-17', 234, 'http://www.myvideo.de/movie/2561293', 0, 0, 0, 'http://www.top10diary.com/wp-content/uploads/2011/05/top-10-Christmas-song-Mariah-Carey-for-All-I-Want-For-Christmas-Is-You.jpg'),
(38, 'Yiruma', 'River Flows In You', '2011-12-17', 239, 'http://www.myvideo.de/movie/8327206', 0, 0, 0, 'http://1.bp.blogspot.com/_CpeqWDTiezU/SOshGuIZtMI/AAAAAAAAAPc/BB2G3or__0k/s320/YirumaJFL.jpg'),
(39, 'Pietro Lombardi', 'Goin'' To L.A.', '2011-12-17', 192, 'http://www.myvideo.de/movie/8322376', 0, 0, 0, 'http://www.celebscandal.org/wp-content/uploads/2011/11/Pietro-Lombardi-Goin-To-L.A.-Cover.jpg'),
(40, 'Lucenzo', 'Danza Kuduro ', '2011-12-17', 240, 'http://www.myvideo.de/movie/8170984', 0, 0, 0, 'http://upload.wikimedia.org/wikipedia/en/thumb/1/1a/Danza_Kuduro_(single_cover).JPG/220px-Danza_Kuduro_(single_cover).JPG'),
(41, 'R.J. feat. Pitbull', 'U Know It Ain''t Love ', '2011-12-17', 210, 'http://www.myvideo.de/movie/8364868', 0, 0, 0, 'http://1.bp.blogspot.com/-bckUIQYxXe0/TtxK9JmJY3I/AAAAAAAABhs/SPiKJfWtuLc/s1600/rj-feat-pitbull-u-know-it-ain-t-love.jpg'),
(42, 'Rosenstolz', 'Wir sind am Leben', '2011-12-17', 303, 'http://www.myvideo.de/movie/8247707', 0, 0, 0, 'http://www.klatsch-tratsch.de/wp-content/uploads/2011/09/album-Cover.jpg'),
(43, 'DJ Ötzi', '	Ring The Bell', '2011-12-17', 182, 'http://www.myvideo.de/movie/8363266', 0, 0, 0, 'http://acharts.us/c/66424-l.jpg'),
(44, 'James Morrison', 'I Won''t Let You Go', '2011-12-17', 239, 'http://www.myvideo.de/movie/8226682', 0, 0, 0, 'http://popdirt.com/images/artwork/James-Morrison-The-Awakening.jpg'),
(45, 'Melanie Thornton', 'Wonderful Dream ', '2011-12-17', 241, 'http://www.myvideo.de/movie/5556887', 0, 0, 0, 'http://d.yimg.com/ec/image/v1/release/39161329%3Bencoding%3Djpg%3Bsize%3D300%3Bfallback%3DdefaultImage'),
(46, 'DJ Antoine vs Timati feat. Kalenna', 'Welcome to St. Tropez', '2011-12-17', 222, 'http://www.myvideo.de/movie/7999310', 0, 0, 0, 'http://4.bp.blogspot.com/-j03E9WOiIUE/TkCf4owLcFI/AAAAAAAAAaw/Imp6OO0mRkA/s1600/Welcome%2BTo%2BSt.%2BTropez.jpg'),
(47, 'Culcha Candela', 'Hungry Eyes', '2011-12-17', 256, 'http://www.myvideo.de/movie/8304093', 0, 0, 0, 'http://img.electro-maniacs.net/36.jpg'),
(48, 'Nena, Rea Garvey, Xavier Naidoo, The BossHoss', 'Heroes / Helden ', '2011-12-17', 210, 'http://www.myvideo.de/movie/8353329', 0, 0, 0, 'http://img.electro-maniacs.net/51040.jpg'),
(49, 'R.I.O.', 'Animal ', '2011-12-17', 222, 'http://www.myvideo.de/movie/8361857', 0, 0, 0, 'http://www.animalshelter.org/mgr/fileAPI.asp%3FtableName%3Dtblrescues%26idField%3DrescueId%26namePrefix%3Dimg%26idValue%3D5010'),
(50, 'Alexandra Stan', 'Mr. Saxobeat', '2011-12-17', 194, 'http://www.myvideo.de/movie/8095653', 0, 0, 0, 'http://1.bp.blogspot.com/-5GYPlUBgd38/TZCaQLnKGGI/AAAAAAAAAS8/31-0HDvkupU/s1600/alexandra-stan-mr-saxobeat.jpg'),
(51, 'Kelly Clarkson', 'Mr. Know It All', '2011-12-17', 233, 'http://www.myvideo.de/movie/8278858', 0, 0, 0, 'http://www.shoppingblog.com/2011pics/kelly_clarkson_mr_know_it_all_cover_art.jpg'),
(52, 'Andreas Gabalier', 'I sing a Liad für di', '2011-12-17', 190, 'http://www.myvideo.de/movie/8212448', 0, 0, 0, 'http://www.schlagerartig.at/news1/Andreas_Gabalier-_I_sing_a_Lied.jpg'),
(53, 'Mike Candys & Evelyn feat Patrick Miller', 'One Night In Ibiza ', '2011-12-17', 174, 'http://www.myvideo.de/movie/8245517', 0, 0, 0, 'http://musbest.com/uploads/posts/2011-09/1315567038_cover.jpg'),
(54, 'Redd feat. Akon & Snoop Dogg', 'I''m Day Dreaming ', '2011-12-17', 242, 'http://www.myvideo.de/movie/8346507', 0, 0, 0, 'http://www.mtv.de/_overdrive_pics/musicvideos/redd/redd_feat_akon_snoop_dogg_im_day_dreaming_640.jpg'),
(55, 'Sak Noel', 'Loca People ', '2011-12-17', 286, 'http://www.myvideo.de/movie/8223662', 0, 0, 0, 'http://2.bp.blogspot.com/-mtb3wYjJEtA/Te5MBOatE-I/AAAAAAAAEO0/vPBaTqmWnwU/s400/Sak-Noel-Loca-People-Cover.jpg'),
(56, 'Jennifer Lopez', 'On The Floor ', '2011-12-17', 268, 'http://www.myvideo.de/movie/8027063', 0, 0, 0, 'http://www.shoppingblog.com/2011pics/jennifer_lopez_on_the_floor_cover_art.jpg'),
(57, 'Justin Bieber', 'Mistletoe', '2011-12-17', 192, 'http://www.myvideo.de/movie/8300991', 0, 0, 0, 'http://www.disneydreaming.com/wp-content/uploads/2011/12/Justin-Bieber-Mistletoe1.jpg'),
(58, 'Pitbull', 'Give Me Everything', '2011-12-17', 265, 'http://www.myvideo.de/movie/8129658', 0, 0, 0, 'http://upload.wikimedia.org/wikipedia/en/thumb/0/06/Pitbull_-_Give_Me_Everything.jpg/220px-Pitbull_-_Give_Me_Everything.jpg'),
(59, 'Sunrise Avenue', 'Hollywood Hills', '2011-12-17', 210, 'http://www.myvideo.de/movie/7999177', 0, 0, 0, 'http://3.bp.blogspot.com/-Y2AkEybAe3w/TtJ5d4kfk3I/AAAAAAAAElQ/uXNxnx1q9sA/s1600/Sunrise%252BAvenue%252B-%252BHollywood%252BHills.jpg'),
(60, 'Rea Garvey', 'Can''t Stand The Silence', '2011-12-17', 217, 'http://www.myvideo.de/movie/8248642', 0, 0, 0, 'http://static.universal-music-services.de/asset_new/261987/878/view/c/Rea-Garvey-Can-t-Stand-The-Silence-album-cover.jpg'),
(61, 'Caro Emerald', 'A Night Like This', '2011-12-17', 232, 'http://www.myvideo.de/movie/7957791', 0, 0, 0, 'http://upload.wikimedia.org/wikipedia/en/thumb/f/f7/A_Night_like_This_cover.png/220px-A_Night_like_This_cover.png'),
(62, 'Ella Endlich', 'Küss Mich, Halt Mich, Lieb Mich', '2011-12-17', 217, 'http://www.myvideo.de/movie/8362267', 0, 0, 0, 'http://www.fan-lexikon.de/musik/ella-endlich/bilder/l/ella-endlich-kuess-mich-halt-mich-lieb-mich-cover-11312.jpg'),
(63, 'Jupiter Jones', 'Still', '2011-12-17', 235, 'http://www.myvideo.de/movie/8007102', 0, 0, 0, 'http://jupiter-jones.de/jj2011/wp-content/uploads/2011/03/cover-still-neu.jpg'),
(64, 'Snoop Dogg vs. David Guetta', 'Sweat ', '2011-12-17', 196, 'http://www.myvideo.de/movie/8038930', 0, 0, 0, 'http://www.frenchtouchmusic.net/wp-content/uploads/2011/06/David-Guetta-Snoop-Dog-Sweat.jpg'),
(65, 'Scooter feat. Vicky Leandros', 'C''est Bleu ', '2011-12-17', 201, 'http://www.myvideo.de/movie/8363358', 0, 0, 0, 'http://www.trancemusic.lv/wp-content/uploads/2011/12/Scooter-feat-Vicky-Leandros-Cest-Bleu.jpg'),
(66, 'Sido feat. Rio Reiser', 'Geboren um frei zu sein', '2011-12-17', 229, 'http://www.myvideo.de/movie/8351486', 0, 0, 0, 'http://www.celebscandal.org/wp-content/uploads/2011/11/Sido-Geboren-um-Frei-zu-sein.jpg'),
(67, 'Band Aid 20', 'Do They Know It''s Christmas?', '2011-12-17', 348, 'http://www.myvideo.de/movie/4892248', 0, 0, 0, 'http://images.uulyrics.com/cover/b/band-aid-20/album-do-they-know-its-christmas.jpg'),
(68, 'Example', 'Changed The Way You Kiss Me', '2011-12-17', 203, 'http://www.myvideo.de/movie/8224203', 0, 0, 0, 'http://2.bp.blogspot.com/-sxh-tNaN3EA/TZ3iKWWBVqI/AAAAAAAAJ14/KJh-Wu7-j3c/s1600/Example-Changed-The-Way-you-Kiss-me.jpg'),
(69, 'Lady Gaga', 'The Edge Of Glory', '2011-12-17', 323, 'http://www.myvideo.de/movie/8178567', 0, 0, 0, 'http://www.hipflowonline.com/wp-content/uploads/2011/05/2940680921.jpg'),
(70, 'Udo Lindenberg', 'Ein Herz kann man nicht reparieren', '2011-12-17', 234, 'http://www.myvideo.de/movie/8248119', 0, 0, 0, 'http://www.udo-lindenberg.de/sixcms/media.php/332/thumbnails/kompletto_cover.jpg.46877.jpg'),
(71, 'Bruno Mars', 'Grenade', '2011-12-17', 221, 'http://www.myvideo.de/movie/7898308', 0, 0, 0, 'http://2.bp.blogspot.com/_mupIVJbjvuU/TKJYtK_slsI/AAAAAAAAHUg/Pbklq_AzjX8/s1600/Bruno%2BMars%2B-%2BGrenade%2B(Official%2BSingle%2BCover).jpg'),
(72, 'Kool Savas', 'AURA ', '2011-12-17', 167, 'http://www.myvideo.de/movie/8338849', 0, 0, 0, 'http://blog.jokerbrand.net/files/2011/11/kool-savas-aura2.jpg'),
(73, 'Frida Gold', 'Wovon sollen wir träumen', '2011-12-17', 209, 'http://www.myvideo.de/movie/8050035', 0, 0, 0, 'http://www.fridagold.com/sites/fridagold.com/files/imagecache/node_lightbox/nodes/teaser-images/fg_traemen_cover.jpg'),
(74, 'Natalia Kills', 'Free ', '2011-12-17', 280, 'http://www.myvideo.de/movie/8197227', 0, 0, 0, 'http://2.bp.blogspot.com/-UnKtWz9YPbQ/ThK-hIK_yhI/AAAAAAAAAb4/vGP1eFJSD1I/s1600/Natalia%2BKills%2B-%2BFree%2B%252528feat.%2Bwill.i.am%252529%2B-%2BSingle%2BiTunes%2Bcover%2B600x600.jpg'),
(75, 'Seeed', 'Molotov / Wonderful Life', '2011-12-17', 374, 'http://www.myvideo.de/movie/8267589', 0, 0, 0, 'http://www.vinylandmore.de/Bilder/Interpret-S/SeeedMolotovWondefulLife600.jpg'),
(76, 'David Guetta', 'Little Bad Girl ', '2011-12-17', 211, 'http://www.myvideo.de/movie/8209600', 0, 0, 0, 'http://1.bp.blogspot.com/-GmmSXM4PJuM/TZJ6uHoA8NI/AAAAAAAAFeA/h1QKunlG8DA/s1600/David%252BGuetta%252B-%252BLittle%252BBad%252BGirl%252B%252528FanMade%252BSingle%252BCover%252529%252BMade%252Bby%252B%25253F.jpg'),
(77, 'Kings Of Leon', 'Use Somebody', '2011-12-17', 230, 'http://www.myvideo.de/movie/5608867', 0, 0, 0, 'http://upload.wikimedia.org/wikipedia/en/a/a0/Use_Somebody.jpg'),
(78, 'Philipp Poisel', 'Eiserner Steg', '2011-12-17', 240, 'http://www.myvideo.de/movie/8273666', 0, 0, 0, 'http://hitparade.ch/cdimag/philipp_poisel-eiserner_steg_s.jpg'),
(79, 'Kings Of Leon', 'Sex On Fire', '2011-12-17', 208, 'http://www.myvideo.de/movie/5053452', 0, 0, 0, 'http://www.jeremyperson.com/wp-content/uploads/2009/12/kings_of_leon_OBTN_cover.jpg'),
(80, 'Ilhama', 'Bei Mir Bist Du Scheen feat. DJ OGB', '2011-12-17', 206, 'http://www.myvideo.de/movie/8326148', 0, 0, 0, 'http://1.bp.blogspot.com/_w_Yp8qhOqHU/S1cryr45onI/AAAAAAAAAi4/641NwpXzj1M/s320/afrojack.jpg'),
(81, 'Train', 'Shake Up Christmas', '2011-12-17', 261, 'http://www.myvideo.de/movie/7912558', 0, 0, 0, 'http://2.bp.blogspot.com/_zjVydElJEho/TOLumq776bI/AAAAAAAABaw/ET-H_GPZN44/s1600/Shake%252BUp%252BChristmas%252B%252528Coke%252BXmas%252BAnthem%252529%252B%252528Official%252BSingle%252BCover%252529.jpg'),
(82, 'Zaz', 'Je Veux', '2011-12-17', 217, 'http://www.myvideo.de/movie/7957724', 0, 0, 0, 'http://4.bp.blogspot.com/_YLRNbuufJSM/TMtHUIaZqzI/AAAAAAAAAZE/3nGmhtxLYxQ/s1600/zaz.jpg'),
(83, 'Chris Brown', 'Beautiful People', '2011-12-17', 224, 'http://www.myvideo.de/movie/8104400', 0, 0, 0, 'http://cdn.idolator.com/wp-content/uploads/2011/02/beautifulbreezy.jpg'),
(84, 'DJ Ötzi', 'I Sing A Liad Für Dich', '2011-12-17', 190, 'http://www.myvideo.de/movie/8248635', 0, 0, 0, 'http://www.musicline.de/cover/DJ%2B%2525d6tzi_I%2BSing%2BA%2BLiad%2BF%2525fcr%2BDich%2B(2-Track)_602527807454.jpg');

--
-- Trigger `song`
--
DROP TRIGGER IF EXISTS `updateSong`;
DELIMITER //
CREATE TRIGGER `updateSong` BEFORE UPDATE ON `song`
 FOR EACH ROW begin
	if (new.voteTotal != old.voteTotal or new.voteCount != old.voteTotal)
	then
		if (new.voteTotal > 0)
		then
			set new.rating = new.voteTotal / new.voteCount;
		else
			set new.rating = 0;
		end if;
	end if;
end
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `song_in_chart`
--

CREATE TABLE IF NOT EXISTS `song_in_chart` (
  `songID` int(11) NOT NULL,
  `chartID` int(11) NOT NULL,
  `ranking` int(11) NOT NULL,
  `change` int(11) DEFAULT NULL,
  PRIMARY KEY (`songID`,`chartID`),
  KEY `chartID` (`chartID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Daten für Tabelle `song_in_chart`
--

INSERT INTO `song_in_chart` (`songID`, `chartID`, `ranking`, `change`) VALUES
(1, 10, 1, NULL),
(2, 10, 2, NULL),
(3, 10, 3, NULL),
(4, 10, 4, NULL),
(5, 10, 5, NULL),
(6, 10, 6, NULL),
(7, 10, 7, NULL),
(8, 10, 8, NULL),
(9, 10, 9, NULL),
(10, 10, 10, NULL),
(11, 10, 11, NULL),
(12, 10, 12, NULL),
(13, 10, 13, NULL),
(14, 10, 14, NULL),
(15, 10, 15, NULL),
(16, 10, 16, NULL),
(17, 10, 17, NULL),
(18, 10, 18, NULL),
(19, 10, 19, NULL),
(20, 10, 20, NULL),
(21, 10, 21, NULL),
(22, 10, 22, NULL),
(23, 10, 23, NULL),
(24, 10, 24, NULL),
(25, 10, 25, NULL),
(26, 10, 26, NULL),
(27, 10, 27, NULL),
(28, 10, 28, NULL),
(29, 10, 29, NULL),
(30, 10, 30, NULL),
(31, 10, 31, NULL),
(32, 10, 32, NULL),
(33, 10, 33, NULL),
(34, 10, 34, NULL),
(35, 10, 35, NULL),
(36, 10, 36, NULL),
(37, 10, 37, NULL),
(38, 10, 38, NULL),
(39, 10, 39, NULL),
(40, 10, 40, NULL),
(41, 10, 41, NULL),
(42, 10, 42, NULL),
(43, 10, 43, NULL),
(44, 10, 44, NULL),
(45, 10, 45, NULL),
(46, 10, 46, NULL),
(47, 10, 47, NULL),
(48, 10, 48, NULL),
(49, 10, 49, NULL),
(50, 10, 50, NULL),
(51, 10, 51, NULL),
(52, 10, 52, NULL),
(53, 10, 53, NULL),
(54, 10, 54, NULL),
(55, 10, 55, NULL),
(56, 10, 56, NULL),
(57, 10, 57, NULL),
(58, 10, 58, NULL),
(59, 10, 59, NULL),
(60, 10, 60, NULL),
(61, 10, 61, NULL),
(62, 10, 62, NULL),
(63, 10, 63, NULL),
(64, 10, 64, NULL),
(65, 10, 65, NULL),
(66, 10, 66, NULL),
(67, 10, 67, NULL),
(68, 10, 68, NULL),
(69, 10, 69, NULL),
(70, 10, 70, NULL),
(71, 10, 71, NULL),
(72, 10, 72, NULL),
(73, 10, 73, NULL),
(74, 10, 74, NULL),
(75, 10, 75, NULL),
(76, 10, 76, NULL),
(77, 10, 77, NULL),
(78, 10, 78, NULL),
(79, 10, 79, NULL),
(80, 10, 80, NULL),
(81, 10, 81, NULL),
(82, 10, 82, NULL),
(83, 10, 83, NULL),
(84, 10, 84, NULL);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Daten für Tabelle `user`
--

INSERT INTO `user` (`id`, `admin`, `email`, `password`) VALUES
(1, 0, 'asd@asd.de', 'asd'),
(2, 0, 'Mateful@web.de', '73675debcd8a436be48ec22211dcf44fe0df0a64'),
(3, 1, 'lotus', 'fc6edd7a185bd0f7fd749cb087713ba01ce3d16c');

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `lyric`
--
ALTER TABLE `lyric`
  ADD CONSTRAINT `lyric_ibfk_1` FOREIGN KEY (`songID`) REFERENCES `song` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints der Tabelle `price`
--
ALTER TABLE `price`
  ADD CONSTRAINT `price_ibfk_1` FOREIGN KEY (`songID`) REFERENCES `song` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints der Tabelle `rating`
--
ALTER TABLE `rating`
  ADD CONSTRAINT `rating_ibfk_3` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rating_ibfk_4` FOREIGN KEY (`songID`) REFERENCES `song` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints der Tabelle `song_in_chart`
--
ALTER TABLE `song_in_chart`
  ADD CONSTRAINT `song_in_chart_ibfk_3` FOREIGN KEY (`songID`) REFERENCES `song` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `song_in_chart_ibfk_4` FOREIGN KEY (`chartID`) REFERENCES `chart` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
