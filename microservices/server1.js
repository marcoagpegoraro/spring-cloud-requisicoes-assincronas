const express = require('express')
const sleep = require('./utils').sleep

const app = express()

musics = [
  { name: "Black", author: "Pearl Jam" },
  { name: "Судно", author: "Молчат Дома" },
  { name: "Let it Be", author: "The Beatles" },
]

function getMusics() {
  sleep()
  return musics
}

app.get('/:id', (req, res) => {
  let musics = getMusics()
  return res.json(musics)
})

module.exports = app