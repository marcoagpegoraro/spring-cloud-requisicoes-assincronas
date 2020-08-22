const express = require('express')
const sleepOneSecond = require('./utils').sleepOneSecond
const port = 3002;

const app = express()

infos = {
  name: "Marco Antonio",
  job: "Developer",
  birthDate: new Date(1999, 9, 17)
}

function getInfos() {
  sleepOneSecond()
  return infos
}

app.get('/:id', (req, res) => {
  let infos = getInfos()
  return res.json(infos)
})

app.listen(port, () => {
  console.log(`Servidor de informações rodando em ${port}`)
})