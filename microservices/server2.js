const express = require('express')
const sleep = require('./utils').sleep

const app = express()

infos = { name: "Marco Antonio", job: "Developer", birthDate: new Date(1999, 9, 17) }


function getInfos() {
  sleep()
  return infos
}

app.get('/:id', (req, res) => {
  let infos = getInfos()
  return res.json(infos)
})

module.exports = app