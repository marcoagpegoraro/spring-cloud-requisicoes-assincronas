"use strict";

var express = require('express');

var sleepOneSecond = require('./utils').sleepOneSecond;

var port = 3003;
var app = express();
texts = [{
  title: "Anakin vs Obi-Wan Quotes",
  description: "It's over Anakin, i have the high ground!"
}];

function getTexts() {
  sleepOneSecond();
  return texts;
}

app.get('/:id', function (req, res) {
  var texts = getTexts();
  return res.json(texts);
});
app.listen(port, function () {
  console.log("Servidor de textos rodando em ".concat(port));
});