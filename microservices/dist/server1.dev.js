"use strict";

var express = require('express');

var sleepOneSecond = require('./utils').sleepOneSecond;

var port = 3001;
var app = express();
musics = [{
  name: "Black",
  author: "Pearl Jam"
}, {
  name: "Судно",
  author: "Молчат Дома"
}, {
  name: "Let it Be",
  author: "The Beatles"
}];

function getMusics() {
  sleepOneSecond();
  return musics;
}

app.get('/:id', function (req, res) {
  var musics = getMusics();
  return res.json(musics);
});
app.listen(port, function () {
  console.log("Servidor de musicas rodando em ".concat(port));
});