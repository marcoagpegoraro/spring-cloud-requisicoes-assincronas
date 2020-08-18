const express = require('express')
const sleep = require('./utils').sleep

const app = express()

texts = [
  { title: "Anakin vs Obi-Wan Quotes", description: "It's over Anakin, i have the high ground!" }
]

function getTexts() {
  sleep()
  return texts
}

app.get('/:id', (req, res) => {
  let texts = getTexts()
  return res.json(texts)
})

module.exports = app