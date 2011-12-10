-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 10. Dezember 2011 um 15:32
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
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Daten für Tabelle `chart`
--

INSERT INTO `chart` (`id`, `name`, `lastUpdated`) VALUES
(1, 'Singlecharts', '2011-11-28 00:00:00'),
(2, 'Singlecharts', '2011-12-08 01:08:16'),
(3, 'Singlecharts', '2011-12-08 01:16:52'),
(4, 'Singlecharts', '2011-12-08 01:18:58');

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
(1, 'http://lyrics.wikia.com/Rihanna:We_Found_Love', 'Yellow diamonds in the light\nAnd we''re standing side by side\nAs your shadow crosses mine\nWhat it takes to come alive\n\nIt''s the way I’m feeling I [...]'),
(2, 'http://lyrics.wikia.com/Taio_Cruz:Hangover', '[Taio Cruz - Hook]\nI got a hangover, wo-oh!\nI''ve been drinking too much for sure\nI got a hangover, wo-oh!\nI got an empty cup\nPour me some more\n\nSo I can go until they close up, eh\nAnd I can drink until I''m told up, eh\nAnd I don''t ever ever want to grow up, eh\nI want to[...]'),
(3, 'http://lyrics.wikia.com/Maroon_5:Moves_Like_Jagger', 'Oh! Oh!\nJust shoot for the stars\nIf it feels right\nThen aim for my heart\nIf you feel like\nAnd take me away\nAnd make it OK\nI swear I’ll behave\n\nYou wanted control\nSo we waited\nI put on a show\nNow I make it\nYou say I’m a kid\nMy ego is big\nI don’t give a shit!\n\nAnd it goes like this\nTake me by the tongue\n[...]'),
(4, 'http://lyrics.wikia.com/Marlon_Roudette:New_Age', 'If love was a word,\nI don''t understand.\nThe simplest sound,\nWith four letters.\nWhatever it was,\nI''m over it now.\nWith every day,\nIt gets better,\nIt gets better.\n\nAre you lovin[...]'),
(5, 'http://lyrics.wikia.com/index.php?title=Sean_Paul:Got+2+Luv+You&amp;action=edit', 'Not found'),
(6, 'http://lyrics.wikia.com/Pitbull:Rain_Over_Me', '''''[Marc Anthony]''''\nGirl, my body don''t lie (RedOne)\nI''m outta my mind\nLet it rain over me (Mr. Worldwide)\nI''m rising so high\nOut of my mind (Marc Anthony)\nSo let it rain over me\n\nAy ay ay\nAy ay ay\nLet it rain over me\nAy ay ay\nAy ay ay\nLet it rain over me\n\n''''[Pitbull]''''\nA billion''s the new million\nVoli''s the new vodka\n40''s the[...]'),
(7, 'http://lyrics.wikia.com/David_Guetta:Without_You', 'I can''t win, I can''t reign\nI will never win this game\nWithout you, without you\nI am lost, I am vain,\nI will never be the same\nWi[...]'),
(8, 'http://lyrics.wikia.com/R.I.O.:Turn_This_Club_Around', 'Turn this club around\nAyo ayo\nAyo ayo\n\nIf you want more\nJust check my swagger out there on the dance floor\nYeah all the ladies gonna knock on my door\nGonna be the time of your life\nWe gonna do it tonight\nDo it tonight\n\nSomething''s heatin'' up, heatin'' up\nGo check my floor\nHey, meet me up, meet me up\nOn th[...]'),
(9, 'http://lyrics.wikia.com/Coldplay:Paradise', 'When she was just a girl\nShe expected the world\nBut it flew away from her reach\nSo she ran away in her sleep\n\nAnd dreamed of para-para-pa[...]'),
(10, 'http://lyrics.wikia.com/index.php?title=Glasperlenspiel:Echt&amp;action=edit', 'Not found'),
(11, 'http://lyrics.wikia.com/James_Morrison:I_Won%27t_Let_You_Go', 'When it''s black\nTake a little time to hold yourself\nTake a little time to feel around\nBefore it''s gone\n\nYou won''t let go\nBut still do you keep on falling down\nRemember how you saved me no[...]'),
(12, 'http://lyrics.wikia.com/LMFAO:Sexy_And_I_Know_It', 'Yeah,\nYeah\nWhen I walk on by, girls be looking like damn he fly\nI pay to the beat, walking down the street with \nmy new la freak, yeah\nThis is how I roll, animal print, pants out''control,\nIt''s RedFoo with the big afro (a$$ ''fro?)\nThey like Bruce Lee roc[...]'),
(13, 'http://lyrics.wikia.com/Example:Changed_The_Way_You_Kiss_Me', 'I''ve never been afraid of the highest heights \nOr afraid of flying, no\nI''ve never been afraid of the wildest fights \nNot afraid of dying \nBut now I want off this ride ''cause your scaring me\nAnd I don''t like wh[...]'),
(14, 'http://lyrics.wikia.com/index.php?title=Lucenzo:Danza+Kuduro&amp;action=edit', 'Not found'),
(15, 'http://lyrics.wikia.com/Sak_Noel:Loca_People', 'All Day All Night\nAll Day All Night\nAll Day All Night\nAll Day All Night\nAll Day All Night\nAll Day All Night\nAll Day All Night\nWHAT TH[...]'),
(16, 'http://lyrics.wikia.com/index.php?title=Mike_Candys_%26_Evelyn_Feat_Patrick_Miller:One+Night+In+Ibiza&amp;action=edit', 'Not found'),
(17, 'http://lyrics.wikia.com/Rosenstolz:Wir_Sind_Am_Leben', 'Hast du alles probiert?\nHast du alles versucht?\nHast du alles getan?\nWenn nicht, fang an!\n\nHast du wirklich gelebt?\nHat deine Welt sich wirklich gedreht?\nHast du alles getan?\nWenn nicht, fang an!\n\nW[...]'),
(18, 'http://lyrics.wikia.com/Snow_Patrol:Called_Out_In_The_Dark', 'It''s like we just can''t help ourselves\nCause we don''t know how to back down\nWe were called out to the streets\nWe were called out into the towns\n\nAnd how the [...]'),
(19, 'http://lyrics.wikia.com/Tim_Bendzko:Nur_Noch_Kurz_Die_Welt_Retten', 'Ich wär so gern dabei gewesen \ndoch ich hab viel zu viel zu tun\nlass uns später weiter reden \nDa draußen brauchen sie mich jetzt \ndie Situation wird unterschätzt \nUnd vielleicht hängt unser Leben davon ab \nIch weiß es ist dir ernst \ndu kannst[...]'),
(20, 'http://lyrics.wikia.com/Lana_Del_Rey:Video_Games', 'Swinging in the backyard\nPull up in your fast car\nWhistling my name\n\nOpen up a beer\nAnd you take it over here\nAnd play a video game\n\nI''m in his favourite sun dress\nWatching me get undressed\nTake that body downtown\n\nI say you the bestest\nLean in for[...]'),
(21, 'http://lyrics.wikia.com/Tim_Bendzko:Wenn_Worte_Meine_Sprache_W%C3%A4ren', 'Wenn Worte meine Sprache wären\nIch hät dir schon gesagt\nIn all den schönen Worten\nWie viel mir an dir lag\nIch kann dich nur ansehen\nWeil ich dich wie eine königin verehr\nDoch ich kann nicht auf dich zugehen\nWeil meine Angst den Weg versperrt\n\nChorus:\n\nMir fehlen die Worte ich\nHab die Worte nicht\nDi[...]'),
(22, 'http://lyrics.wikia.com/index.php?title=DJ_Antoine_Vs_Timati:Welcome+to+St.+Tropez&amp;action=edit', 'Not found'),
(23, 'http://lyrics.wikia.com/Natalia_Kills:Free', 'get''cha 5''s, get''cha 10''s, get''cha 20''s out\nget''cha 5''s, get''cha 10''s, get''cha 20''s out\nget''cha 5''s, get''cha 10''s, get''cha 50''s out\nget''cha 5''s, get''cha 10''s, get''cha 50''s out\n\nI''m free, I just spent all my money\nbut I rocked that like it don''t cost a thing\nfree\nburned a hole in my pocket\nbut I rocked that like it don''t cost a thing\n\ncall me a perfectionist\naddicted to[...]'),
(24, 'http://lyrics.wikia.com/index.php?title=Seeed:Molotov+%2F+Wonderful+Life&amp;action=edit', 'Not found'),
(25, 'http://lyrics.wikia.com/Alexandra_Stan:Mr._Saxobeat', 'You make me this,\nBring me up,\nBring me down,\nPlaying sweet,\nMake me move like a freak,\nMr. Saxobeat.\n\nHe makes me this,\nBrings me up,\nBrings me down,\nDancing sweet,\nMakes me move like a freak, ''''(Mr. Saxobeat)''''\nMr. Saxobea[...]'),
(26, 'http://lyrics.wikia.com/Lady_Gaga:Yo%C3%BC_And_I', 'It’s been a long time since I came around\nBeen a long time but I’m back in town\nThis time I’m not leaving without you\n\nYou taste like whiskey when you kiss me, oooh\nI’ll give anything again to be your baby doll\nThis time I’m not leaving without you\n\nHe said sit back down where you belong\nIn the corner [...]'),
(27, 'http://lyrics.wikia.com/Philipp_Poisel:Eiserner_Steg', 'Ich atme dich ein\nund nie wieder aus.\nSchließ'' dich in mein Herz.\nLass dich nicht mehr raus.\n\nIch trage dich bei mir\nin meiner Brust.\nHätt'' alle Wege verändert.\nHätt'' ich sie vorh[...]'),
(28, 'http://lyrics.wikia.com/Udo_Lindenberg:Ein_Herz_Kann_Man_Nicht_Reparieren', 'Hör'' mir jetzt mal zu, laß mich jetzt in Ruh''\nund ruf'' mich nicht mehr an...\nIch hab'' keine Zeit, nicht gestern und nicht heut'',\nnicht morgen und nicht irgendwann\nMach dir endlich klar...es ist nicht mehr - es war...\n\nDu mußt das kapier''n, eins wird nicht passiern''n,\nmich kri[...]'),
(29, 'http://lyrics.wikia.com/30_Seconds_To_Mars:The_Kill', 'What if I wanted to break?\nLaugh it all off in your face\nWhat would you do?\nWhat if I fell to the floor?\nCouldn''t take all this anymore\nWhat would[...]'),
(30, 'http://lyrics.wikia.com/Jupiter_Jones:Still', 'So still, dass jeder von uns wusste, das hier ist\nfür immer, für immer und ein Leben und es war\nso still, dass jeder von uns ahnte, hierfür gibts kein Wort, \ndas jemals das Gefühl beschreiben kann.\n\nSo still, dass alle Uhren schwiegen,\nja, die Zeit k[...]'),
(31, 'http://lyrics.wikia.com/Pitbull:Give_Me_Everything', '''''''Pitbull''''''\nMe not working hard?\nYeah right picture that with a Kodak\nOr better yet, go to Times Square\nTake a picture of me with a Kodak\nTook my life from negative to positive\nI just want y''all to know that\nAnd tonight, let''s enjoy life\nPitbull, Nayer, Ne-Yo that''s right\n\n''''''Ne-Yo''''''\nTonight I want all of you tonight\nGive me everything tonight\nFor all we know we might not get tomorrow\nLet''s do it tonight\n\n''''''Nayer''''''\nDon''t care what they say\nAll the game[...]'),
(32, 'http://lyrics.wikia.com/LMFAO:Party_Rock_Anthem', '''''Party rock! Yeah! Whoo! Let''s go!''''\n\nParty rock is in the house tonight\nEverybody just have a good time ''''(yeah)''''\nAnd we gon'' make you lose your mind ''''(whoo!)''''\nEverybody just have a good time ''''(clap!)''''\n\nParty rock is in the house tonight ''''(oh!)''''\nEverybody just have a good time ''''(Like the feelin, mane!)''''\nAnd we gon'' make you lose your mind ''''(yeah!)''''\nWe just wanna see [...]'),
(33, 'http://lyrics.wikia.com/Kelly_Clarkson:Mr._Know_It_All', 'Mr. Know It All\nWell ya think you know it all\nBut ya don''t know a thing at all\nAin''t it something y''all\nWhen somebody tells you something bout you\nThink that they know you more than you do\nSo you take it down another pill to swallow\n\nMr. Bring Me Down\nWell ya like to bring me down don[...]'),
(34, 'http://lyrics.wikia.com/index.php?title=Reamonn:Can%27t+Stand+The+Silence&amp;action=edit', 'Not found'),
(35, 'http://lyrics.wikia.com/index.php?title=DJ_%C3%96tzi:I+Sing+A+Liad+F%C3%83%C2%BCr+Dich&amp;action=edit', 'Not found'),
(36, 'http://lyrics.wikia.com/index.php?title=J%C3%83%C2%BCrgen_Drews:Wenn+die+Wunderkerzen+brennen&amp;action=edit', 'Not found'),
(37, 'http://lyrics.wikia.com/index.php?title=Timbaland:Pass+At+Me&amp;action=edit', 'Not found'),
(38, 'http://lyrics.wikia.com/Jennifer_Lopez:On_The_Floor', '''''''Pitbull:''''''\nJ. Lo!\nThe other side, out my mine\n\n''''''Jennifer Lopez:''''''\nIt''s a new generation \n(Mr. Worldwide)\nOf party people\n\n''''''Pitbull:''''''\nGet on the floor, dale!\nGet on the floor\n({{wp|RedOne}}!)\n\n''''''Jennifer Lopez:''''''\nLet me introduce you to my party people\nIn the club...\n\n''''''Pitbull:''''''\nI''m loose\nAnd everybody knows I get off the train\nBaby, it''s t[...]'),
(39, 'http://lyrics.wikia.com/index.php?title=Katzenjammer:I+Will+Dance&amp;action=edit', 'Not found'),
(40, 'http://lyrics.wikia.com/Andreas_Gabalier:I_Sing_A_Liad_F%C3%BCr_Di', 'I sing a liad für di\nUnd daun frogst du mi\nMogst mid mir daunzn gehn\nI glaub i steh auf di\n\nI sing a liad für die\nUnd kaun di sterndal seng\nI hob mi verknoid in di\n\nI hob a engal gseng\nÜber di strossn gehn\nEs hod so liab glocht\nIn an[...]'),
(41, 'http://lyrics.wikia.com/index.php?title=Frida_Gold:Wovon+sollen+wir+tr%C3%83%C2%A4umen&amp;action=edit', 'Not found'),
(42, 'http://lyrics.wikia.com/Red_Hot_Chili_Peppers:The_Adventures_Of_Rain_Dance_Maggie', 'Lipstick junkie\nDebunk the all-in-one\nShe came back wearing a smile\nLookin'' like someone drugged me\nThat wanted to unplug me\nNo one in here is on trial\nIt''s just a turn-around\n\nAnd we go\nOh\nWel[...]'),
(43, 'http://lyrics.wikia.com/Brooke_Fraser:Something_In_The_Water', 'Do-do  do-do-do  do-do-do-do-do\n\nI wear a demeanor made of bright pretty things\nWhat she wears, what she wears, what she wears\nBirds singing on my shoulder in harmony it seems\nHow they sing, how they sing, how they sing\n\nGiv[...]'),
(44, 'http://lyrics.wikia.com/Lady_Gaga:The_Edge_Of_Glory', 'There''s no reason you and me should be alone\nTonight, yeah babe\nTonight, yeah babe\nThere''s no reason you shouldn''t take me home tonight\n\nI need a man who thinks it right when it''s so wrong,\nTonight yeah babe,\nTonight yeah babe,\nRight on the limits w[...]'),
(45, 'http://lyrics.wikia.com/index.php?title=Snoop_Dogg_Vs._David_Guetta:Sweat&amp;action=edit', 'Not found'),
(46, 'http://lyrics.wikia.com/David_Guetta:Little_Bad_Girl', '[Taio Cruz]\nOh yeah, \nThey tell me I''m a bad boy \nAll the ladies look at me and act coy \nI just like to put my hands up in the air \nI want that girl dancing over there \n\nLook at her go on the dancefloor \nShe''s amazing on the dancefloor \nWhen she moves, girl I want more \nKeep it going girl, like I got an encore \nYou got me saying: \n\nGo little bad girl, little bad girl \nGo little bad girl, little bad gir[...]'),
(47, 'http://lyrics.wikia.com/Jason_Der%C3%BClo:Don%27t_Wanna_Go_Home', 'Jason Derülo\n\nCheck that out what they playin''\nThat''s my song, that''s my song\nWhere my drinks\nI''ve been waiting much too long, much too long\nAnd this girl in my lap passing out, she''s a blonde\nThe last thing on my mind is going home\n\nFrom the window to the wall\nThi[...]'),
(48, 'http://lyrics.wikia.com/index.php?title=Madcon:Helluva+Nite&amp;action=edit', 'Not found'),
(49, 'http://lyrics.wikia.com/Caro_Emerald:Stuck', 'I close my eyes and dream about a sunny holiday\nI wish that I was beachin'' down on Saint Tropez\nOr sitting in the lobby at the fabulous Pierre\nWith diamonds on my fingers and not a single care\n\nInstead I''m on the Avenue where nobody goes\nWith fields of g[...]'),
(50, 'http://lyrics.wikia.com/index.php?title=The_Black_Eyed_Peas:Don%3Ft+Stop+The+Party&amp;action=edit', 'Not found'),
(51, 'http://lyrics.wikia.com/Beyonc%C3%A9:Best_Thing_I_Never_Had', 'What goes around comes back around (hey, my baby)\nWhat goes around comes back around (hey, my baby)\nI say, what goes around comes back around (hey, my baby)\nWhat goes around comes back around\n\nThere was a time\nI thought that you did everything right\nNo lies, no wrong\nBoy, I must''ve been outta my mind\nSo when I think of th[...]'),
(52, 'http://lyrics.wikia.com/Caro_Emerald:A_Night_Like_This', 'From where you are\nYou see the smoke start to arise\nWhere they play cards\n\nAnd you walk over\nSoftly moving passed the guards\nThe stakes are getting higher\nYou can feel it in your heart\n\nHe calls you bluff\nHe is the ace you never thought\nHe played t[...]'),
(53, 'http://lyrics.wikia.com/Bad_Meets_Evil:Lighters', '''''''Bruno Mars'''''':\nThis one''s for you and me, livin'' out our dreams\nWe''re all right where we should be\nLift my arms out wide, I open my eyes, and now all I wanna see\nIs a sky full of lighters, a sky full of lighters\n\n''''''Eminem'''''':\nBy the time you hear this I will have already spiraled up\nI would never do nothing to let you cowards fuck my world up\nIf I was you, I would duck, or get struck like lightning\nFighters keep fighting, put your lighters up, point em'' skyward, uh\n\nHad a dream I was king, I woke up, still king\nThis rap game''s nipple is mine for the milking\nTill nobody else even fucking feels me, till[...]'),
(54, 'http://lyrics.wikia.com/Leona_Lewis:Run', 'I''ll sing it one last time for you\nThen we really have to go\nYou''ve been the only thing that''s right\nIn all I''ve done\n\nAnd I can barely look at you\nBut every single time I do[...]'),
(55, 'http://lyrics.wikia.com/Coldplay:Every_Teardrop_Is_A_Waterfall', 'I turn the music up, I got my records on\nI shut the world outside until the lights come on\nMaybe the streets alight, maybe the trees are gone\nI feel my heart start beating to my[...]'),
(56, 'http://lyrics.wikia.com/David_Guetta:Where_Them_Girls_At', 'So many girls in here, where do I begin?\nI seen this one, I’m bout to go in\nThen she said, I’m here with my friends\nShe got me thinking and that''s when I said\n\nWhere dem girls at, girls at?\nWhere dem girls at, girls at?\nWhere dem girls at, girls at?\nSo go get them, we can all be friends\n\n[Flo Rida - Verse 1]\nHey, bring it on baby, all your friends\nYou’re the shit and I lo[...]'),
(57, 'http://lyrics.wikia.com/Milow:Little_In_The_Middle', 'You always wanted to be\nPart of a circus company\nFor the fun and death defying\nBut in time you forgot life is small [...]'),
(58, 'http://lyrics.wikia.com/The_Good_Natured:Skeleton', 'Stop what you''re doing\nHey come on over\nWhat can I do today\nSee me standing naked hot for you\nAnd I''m taking it all off fo[...]'),
(59, 'http://lyrics.wikia.com/Sunrise_Avenue:I_Don%27t_Dance', 'I don''t wanna grow up,\nI don''t wanna see sex and the city,\nlust for a minute.\nI don''t wanna do that,\nI don''t wanna let go on the floor tonight.\n\nAnd I can''t hear nothing, but beats and sounds\nthat don''t feel good inside.\nI got[...]'),
(60, 'http://lyrics.wikia.com/index.php?title=Frida_Gold:Unsere+Liebe+ist+aus+Gold&amp;action=edit', 'Not found'),
(61, 'http://lyrics.wikia.com/Andreas_Bourani:Nur_In_Meinem_Kopf', 'Ich kann in drei Sekunden die Welt erobern\nDen Himmel stürmen und in mir wohnen\nIn zwei Sekunden Frieden stiften\nLiebe machen, den Feind vergiften\n\nIn ''ner Sekunde Schlösser bauen\nZwei Tage einzie[...]'),
(62, 'http://lyrics.wikia.com/index.php?title=Helene_Fischer:Ph%C3%83%C2%A4nomen&amp;action=edit', 'Not found'),
(63, 'http://lyrics.wikia.com/Zaz:Je_Veux', 'Donnez moi une suite au Ritz, je n''en veux pas ! \n\nDes bijoux de chez CHANEL, je n''en veux pas ! \nDonnez moi une limousine, j''en ferais quoi ? papalapapapala \nOffrez moi du per[...]'),
(64, 'http://lyrics.wikia.com/Bruno_Mars:The_Lazy_Song', 'Today I don''t feel like doing anything\nI just wanna lay in my bed\nDon''t feel like picking up my phone\nSo leave a message at the tone\n''Cause today I swear I''m not doing anything\n\nI''m gonna kick my feet up and stare at the fan\nTurn the TV on\nThrow my hand i[...]'),
(65, 'http://lyrics.wikia.com/Chris_Brown:Beautiful_People', 'Everywhere everywhere\nEverywhere I go\nEverywhere that i''ve been\nThe only thing I see is\nIs beautiful people\nBeautiful people\nBeautiful people\nBeautiful people\n\nDon''t you know don''t you know\nYou''re beautiful don''t y[...]'),
(66, 'http://lyrics.wikia.com/index.php?title=23:So+mach+ich+es&amp;action=edit', 'Not found'),
(67, 'http://lyrics.wikia.com/Casper:So_Perfekt', 'Part 1:\n\nBist du der, der sich nach vorne setzt?\nDen man beim Sport zu letzt wählt?\nSich quält zwischen Cheerleadern und Quarterbacks?\nDen man in die Tonne steckt? Nicht dein Tag, jahrelang.\nDann in der Abschlussnacht ganz allein zum Ball g[...]'),
(68, 'http://lyrics.wikia.com/Sunrise_Avenue:Hollywood_Hills', 'Now this is not the time or the place\nFor a broken-hearted\n''Cause this is the end of the rainbow\nWhere no one can be too sad\n\nNo, I don''t wanna leave\nBut I must keep moving ahead\n''Cause my life belongs to the o[...]'),
(69, 'http://lyrics.wikia.com/Bag_Raiders:Way_Back_Home', 'Rain pours down over a city\nNight has fallen like a stone\nAre you gone or are you with me?\nIn my h[...]'),
(70, 'http://lyrics.wikia.com/index.php?title=Mark_Medlock:The+Other+Side+Of+Broken&amp;action=edit', 'Not found'),
(71, 'http://lyrics.wikia.com/index.php?title=WHITE_APPLE_TREE:Snowflakes&amp;action=edit', 'Not found'),
(72, 'http://lyrics.wikia.com/Bruno_Mars:Grenade', 'Easy come, easy go, that''s just how you l[...]'),
(73, 'http://lyrics.wikia.com/index.php?title=Bosse:Frankfurt+Oder&amp;action=edit', 'Not found'),
(74, 'http://lyrics.wikia.com/Jessie_J:Price_Tag', 'Okay, Coconut Man, Moonheads, and Pea.\nYou ready?\n\nSeems like everybody''s got a price,\nI wonder how they sleep at night.\nWhen the sale comes first\nAnd the truth comes second,\nJust stop for a minute and smile.\n\nWhy is everybody so serious?\nActing so damn mysterious.\nGot your shades on your eyes\nAnd your heels so high\nThat you can''t even have a good time.\n\nEverybody look to the left, (yeah)[...]'),
(75, 'http://lyrics.wikia.com/Rihanna:California_King_Bed', 'Chest to chest\nNose to nose\nPalm to palm\nWe were always just that close\nWrist to wrist\nToe to toe\nLips that felt just like the inside of a rose\nSo how come when I reach out my fingers\nIt fe[...]'),
(76, 'http://lyrics.wikia.com/index.php?title=Mickie_Krause:Schatzi+Schenk+Mir+Ein+Foto&amp;action=edit', 'Not found'),
(77, 'http://lyrics.wikia.com/Andreas_Bourani:Eisberg', 'Ich zeig dir nur die weiße Spitze\nDie gute Seite, rein und klar\nDer ganze Dreck, auf dem ich sitze\nIst für dein Auge unsichtbar\n\nBin wie ein Eisberg, hart und unverletzbar\nIch treib[...]'),
(78, 'http://lyrics.wikia.com/Pigeon_John:The_Bomb', 'Wait, wake up in the morning to the clear blue sky\nTurn up the music when I hop in the ride\nThe windows down let the whole world see\nCan’t nobody rock it like the little old me\n\nI’m the bomb and I’m ’bout to blow up\nI’m the bomb and I’m ’bout to blow up\n\nI got my chucks and my dickies and I put it on black\nBanging Sinatra in the blac[...]'),
(79, 'http://lyrics.wikia.com/Gypsy_%26_The_Cat:Jona_Vark', 'She walks down the street\nAlone in the dark\nHer hands held up high\nAnd shes got nothing[...]'),
(80, 'http://lyrics.wikia.com/Unheilig:Geboren_Um_Zu_Leben', 'Es fällt mir schwer \nohne dich zu leben, \njeden Tag zu jeder Zeit \neinfach alles zu geben. \nIch denk so oft \nzurück an das was war, \nan jedem so geliebten\nvergangenen Tag. \nIch stell mir vor \ndass du zu mir stehst \nund jeden meiner Wege \nan meiner Seite gehst[...]'),
(81, 'http://lyrics.wikia.com/Jennifer_Lopez:I%27m_Into_You', 'AHEM!\nHi, I''m Tune.\nThe man on the moon.\nI live on the beach.\n\nGet the sand out your shoes.\nAnd all of that changed since I met you.\nSo we could leave that old shit in the restroom.\nYoung Money!\n\nYou got me and I could not defend it.\nI tried, but I had to surrender.\nYour star got me under the spellbound.\nLeft me no other choice, but to get down.\n\nIt''s too late. (Lil Wayne: It''s[...]'),
(82, 'http://lyrics.wikia.com/Wiz_Khalifa:Black_And_Yellow', 'Uh huh, you know what it is\nBlack and yellow [x4]\nUh huh, you know what it is\nBlack and yellow [x4]\n\nYeah, uh huh, you know what it is\nEverything I do, I do it big\nYeah, uh huh, screamin'' that''s nothin''\nWhat I pulled off the lot, that''s stuntin''\nReppin'' my town when you see me you know everything\nBlack and yellow [x4]\nI put it down from the whip to my diamonds I''m in\nBlack and yellow [x[...]'),
(83, 'http://lyrics.wikia.com/index.php?title=Katy_Perry:Last+Friday+Night+Extended+Version&amp;action=edit', 'Not found'),
(84, 'http://lyrics.wikia.com/index.php?title=Scooter:David+Doesn%27t+Eat&amp;action=edit', 'Not found'),
(85, 'http://lyrics.wikia.com/index.php?title=Roger_Cicero:In+diesem+Moment&amp;action=edit', 'Not found'),
(86, 'http://lyrics.wikia.com/Inna:Sun_Is_Up', 'All the people tonight put your hands in the sky,\nCome on boy, come and get in,\nThe rhythm music will take you high.\nWhat I''m feeling about you,\nI love you[...]'),
(87, 'http://lyrics.wikia.com/index.php?title=DJ_Antoine:Ma+Ch%C3%83%C2%A9rie&amp;action=edit', 'Not found'),
(88, 'http://lyrics.wikia.com/index.php?title=Chris_Brown_Feat_Justin_Bieber:Next+To+You&amp;action=edit', 'Not found');

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
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=109 ;

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
(88, 'Chris Brown feat Justin Bieber', 'Next To You', '2011-11-26', 361, '<a href="http://www.myvideo.de/watch/8190729/Chris_Brown_feat_Justin_Bieber_Next_To_You">Chris_Brown_feat_Justin_Bieber_Next_To_You</a>', 0, 0, 0, 'onseData'),
(105, 'Professor Green', 'Read All About It ', '2011-12-06', 234, '<a href="http://www.myvideo.de/watch/8325318/Professor_Green_Read_All_About_It_feat_Emeli_Sand">Professor_Green_Read_All_About_It_feat_Emeli_Sand</a>', 0, 0, 0, NULL),
(104, 'Michael Mind Project feat. Bobby Anthony & Rozette', 'Rio De Janeiro', '2011-12-06', 198, '<a href="http://www.myvideo.de/watch/8350504/Michael_Mind_Project_feat_Bobby_Anthony_Rozette_Rio_De_Janeiro">Michael_Mind_Project_feat_Bobby_Anthony_Rozette_Rio_De_Janeiro</a>', 0, 0, 0, NULL),
(103, 'Kool Savas', 'AURA Official HD Video 2011', '2011-12-06', 167, '<a href="http://www.myvideo.de/watch/8338849/Kool_Savas_AURA_Official_HD_Video_2011">Kool_Savas_AURA_Official_HD_Video_2011</a>', 0, 0, 0, NULL),
(102, 'Remady Feat. Manu-L', 'Give Me A Sign ', '2011-12-06', 235, '<a href="http://www.myvideo.de/watch/8333984/Remady_Feat_Manu_L_Give_Me_A_Sign_Official_Video">Remady_Feat_Manu_L_Give_Me_A_Sign_Official_Video</a>', 0, 0, 0, NULL),
(101, 'Justin Bieber', 'Mistletoe', '2011-12-06', 192, '<a href="http://www.myvideo.de/watch/8300991/Justin_Bieber_Mistletoe">Justin_Bieber_Mistletoe</a>', 0, 0, 0, NULL),
(100, 'Ilhama', 'Bei Mir Bist Du Scheen feat. DJ OGB', '2011-12-06', 206, '<a href="http://www.myvideo.de/watch/8326148/Ilhama_Bei_Mir_Bist_Du_Scheen_feat_DJ_OGB">Ilhama_Bei_Mir_Bist_Du_Scheen_feat_DJ_OGB</a>', 0, 0, 0, NULL),
(99, 'Christian Franke & Edward Simoni', 'Der Apfelbaum', '2011-12-06', 232, '<a href="http://www.myvideo.de/watch/8337524/Christian_Franke_Edward_Simoni_Der_Apfelbaum">Christian_Franke_Edward_Simoni_Der_Apfelbaum</a>', 0, 0, 0, NULL),
(98, 'The BossHoss', 'Don''t Gimme That', '2011-12-06', 210, '<a href="http://www.myvideo.de/watch/8303845/The_BossHoss_Don_t_Gimme_That">The_BossHoss_Don_t_Gimme_That</a>', 0, 0, 0, NULL),
(97, 'Ardian Bujupi', 'This Is My Time', '2011-12-06', 209, '<a href="http://www.myvideo.de/watch/8328920/Ardian_Bujupi_This_Is_My_Time">Ardian_Bujupi_This_Is_My_Time</a>', 0, 0, 0, NULL),
(96, 'Bruno Mars', 'It Will Rain', '2011-12-06', 258, '<a href="http://www.myvideo.de/watch/8344476/Bruno_Mars_It_Will_Rain">Bruno_Mars_It_Will_Rain</a>', 0, 0, 0, NULL),
(95, 'Culcha Candela', 'Hungry Eyes', '2011-12-06', 256, '<a href="http://www.myvideo.de/watch/8304093/Culcha_Candela_Hungry_Eyes">Culcha_Candela_Hungry_Eyes</a>', 0, 0, 0, NULL),
(94, 'Jessie J', 'Domino', '2011-12-06', 242, '<a href="http://www.myvideo.de/watch/8295110/Jessie_J_Domino">Jessie_J_Domino</a>', 0, 0, 0, NULL),
(93, 'Pietro Lombardi', 'Goin'' To L.A.', '2011-12-06', 192, '<a href="http://www.myvideo.de/watch/8322376/Pietro_Lombardi_Goin_To_L_A">Pietro_Lombardi_Goin_To_L_A</a>', 0, 0, 0, NULL),
(92, 'Foster The People', 'Pumped Up Kicks', '2011-12-06', 241, '<a href="http://www.myvideo.de/watch/8167247/Foster_The_People_Pumped_Up_Kicks">Foster_The_People_Pumped_Up_Kicks</a>', 0, 0, 0, NULL),
(91, 'Nickelback', 'When We Stand Together ', '2011-12-06', 194, '<a href="http://www.myvideo.de/watch/8328930/Nickelback_When_We_Stand_Together_Official_Video">Nickelback_When_We_Stand_Together_Official_Video</a>', 0, 0, 0, NULL),
(90, 'Udo Lindenberg', 'Cello ', '2011-12-06', 217, '<a href="http://www.myvideo.de/watch/8296234/Udo_Lindenberg_Cello_feat_Clueso">Udo_Lindenberg_Cello_feat_Clueso</a>', 0, 0, 0, NULL),
(89, 'Flo Rida', 'Good Feeling ', '2011-12-06', 258, '<a href="http://www.myvideo.de/watch/8317540/Flo_Rida_Good_Feeling_Official_Video">Flo_Rida_Good_Feeling_Official_Video</a>', 0, 0, 0, NULL),
(106, 'Tom Lüneburger & Stefanie Klo&szlig;', 'We Are One', '2011-12-06', 202, '<a href="http://www.myvideo.de/watch/8315824/Tom_Lueneburger_Stefanie_Kloss_We_Are_One">Tom_Lueneburger_Stefanie_Kloss_We_Are_One</a>', 0, 0, 0, NULL),
(107, 'Usher', 'More', '2011-12-06', 220, '<a href="http://www.myvideo.de/watch/8033015/Usher_More">Usher_More</a>', 0, 0, 0, NULL),
(108, 'David Guetta', 'Where Them Girls At', '2011-12-06', 228, '<a href="http://www.myvideo.de/watch/8188747/David_Guetta_Where_Them_Girls_At">David_Guetta_Where_Them_Girls_At</a>', 0, 0, 0, NULL);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `song_in_chart`
--

CREATE TABLE IF NOT EXISTS `song_in_chart` (
  `songID` int(11) NOT NULL,
  `chartID` int(11) NOT NULL,
  `ranking` int(11) NOT NULL,
  PRIMARY KEY (`songID`,`chartID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Daten für Tabelle `song_in_chart`
--

INSERT INTO `song_in_chart` (`songID`, `chartID`, `ranking`) VALUES
(89, 1, 1),
(1, 1, 2),
(20, 1, 3),
(2, 1, 4),
(6, 1, 5),
(90, 1, 6),
(7, 1, 7),
(3, 1, 8),
(12, 1, 9),
(5, 1, 10),
(18, 1, 11),
(4, 1, 12),
(91, 1, 13),
(92, 1, 14),
(9, 1, 15),
(93, 1, 16),
(10, 1, 17),
(11, 1, 18),
(17, 1, 19),
(19, 1, 20),
(21, 1, 21),
(33, 1, 22),
(16, 1, 23),
(94, 1, 24),
(8, 1, 25),
(14, 1, 26),
(15, 1, 27),
(95, 1, 28),
(96, 1, 29),
(87, 1, 30),
(13, 1, 31),
(97, 1, 32),
(22, 1, 33),
(98, 1, 34),
(99, 1, 35),
(32, 1, 36),
(85, 1, 37),
(100, 1, 38),
(23, 1, 39),
(24, 1, 40),
(28, 1, 41),
(101, 1, 42),
(30, 1, 43),
(35, 1, 44),
(40, 1, 45),
(102, 1, 46),
(31, 1, 47),
(26, 1, 48),
(25, 1, 49),
(27, 1, 50),
(103, 1, 51),
(34, 1, 52),
(38, 1, 53),
(41, 1, 54),
(54, 1, 55),
(45, 1, 56),
(44, 1, 57),
(39, 1, 58),
(36, 1, 59),
(61, 1, 60),
(104, 1, 61),
(62, 1, 62),
(63, 1, 63),
(43, 1, 64),
(42, 1, 65),
(105, 1, 66),
(52, 1, 67),
(106, 1, 68),
(49, 1, 69),
(46, 1, 70),
(107, 1, 71),
(47, 1, 72),
(73, 1, 73),
(37, 1, 74),
(72, 1, 75),
(57, 1, 76),
(59, 1, 77),
(76, 1, 78),
(48, 1, 79),
(68, 1, 80),
(108, 1, 81),
(64, 1, 82),
(80, 1, 83);

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
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Daten für Tabelle `user`
--

INSERT INTO `user` (`id`, `admin`, `email`, `password`) VALUES
(1, 0, 'asd@asd.de', 'asd'),
(2, 0, 'Mateful@web.de', '73675debcd8a436be48ec22211dcf44fe0df0a64');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
