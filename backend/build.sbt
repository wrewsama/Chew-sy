name := """backend"""
organization := "wrew"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.13.10"

libraryDependencies += guice

libraryDependencies += "com.h2database" % "h2" % "1.4.192" 

libraryDependencies += javaJdbc

libraryDependencies += evolutions 
