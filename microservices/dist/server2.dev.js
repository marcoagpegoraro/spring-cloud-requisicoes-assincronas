"use strict";

var express = require('express');

var sleepOneSecond = require('./utils').sleepOneSecond;

var port = 3002;
var app = express();
infos = {
  name: "Marco Antonio",
  job: "Developer",
  birthDate: new Date(1999, 9, 17)
};

function getInfos() {
  sleepOneSecond();
  return infos;
}

app.get('/:id', function (req, res) {
  var infos = getInfos();
  return res.json(infos);
});
app.listen(port, function () {
  console.log("Servidor de informa\xE7\xF5es rodando em ".concat(port));
});