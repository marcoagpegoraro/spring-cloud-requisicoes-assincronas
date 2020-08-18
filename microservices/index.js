const app1 = require('./server1')
const app2 = require('./server2')
const app3 = require('./server3')
const port1 = 3001;
const port2 = 3002;
const port3 = 3003;

app1.listen(port1, () => {
  console.log(`Servidor de musicas rodando em ${port1}`)
})

app2.listen(port2, () => {
  console.log(`Servidor de informações rodando em ${port2}`)
})

app3.listen(port3, () => {
  console.log(`Servidor de textos rodando em ${port3}`)
})