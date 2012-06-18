EnerGI-3D
=========

An Energetic Game Interface for 3D first-person games.

Installation
============
1. 	Download the zip file to your computer
2. 	Unzip the contents into any folder you like.
3. 	Ensure that the EnerGI jar file, the LWJGL jar files and the slick-util jar file are in the same location, along with the native
	libraries (with a .lzma suffix).
4. 	It is ideal to place the javadoc and source firectories in the same place as the libraries (or as other javadoc and source folders)

Setting up in NetBeans
======================
1. Go to Tools->Libraries
2. Click 'Add Library...'
3. Type in a name for the library (best to use EnerGI). Click OK
4. Add energi.jar, lwjgl.jar, lwjgl-util.jar, jinput.jar and slick-util.jar to the classpath list under the classpath tab
5. (optional) Add the javadoc folder under the javadoc tab
	* This allows Javadoc tooltips to show when using API functions while typing them into NetBeans
6. (optional) Add the source folder to the sources tab.
7. Click OK to save the library.

Bundling the library with a finished game
=========================================

To bundle EnerGI with an EnerGI game, copy EnerGI and its dependencies along with the game's jar file.
Ensure they are in the same directory. Copy the natives as well, otherwise the game will not work properly.

You may create a launcher using any method you wish in order to encapsulate the libraries, whether it be another jar or 
an executable that invokes the jar file

Cloning this repository
=======================
Whilst this project is techically open-source, I do not allow anyone to use this library without my express permission first (but don't worry,
I will in most cases allow use, as long as I receive due credit). If you wish to contribute, let me know and I will allow you to make changes.
If you do make a change that ends up in the final product, I will list you in the developer credits.