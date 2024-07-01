# Jogo de RPG

## Classes

Pontos de habilidade são os pontos necessários para uma classe utilizar uma habilidade, cada habilidade gasta 5 pontos. A cada 3 rodadas, os pontos de habilidades de todos são recarregados.

Por padrão, todas as classes começam com 5 pontos de habilidade (exceto Mago). Cada personagem pode acumular até 10 pontos de habilidade.

### Bárbaro
- *Pontos de Vida:* 25
- *Dano:* 10
- *Propriedades:* 10% chance de crítico ao atacar
- *Habilidades:* (nenhuma)
- *Destreza:* 0
- *Vantagens:* (nenhuma)
- *Desvantagens:* Incorpóreo

### Arqueiro
- *Pontos de Vida:* 20
- *Dano:* 3
- *Propriedades:* 10% de esquivar quando atacado
- *Habilidades:*
  - Flecha de fogo (dano +10, 50% chance de queimadura)
- *Destreza:* 5
- *Vantagens:* Monstro
- *Desvantagens:* Incorpóreo

### Druida
- *Pontos de Vida:* 25
- *Dano:* 5
- *Propriedades:* 10% chance de cura +5
- *Habilidades:*
  - Cura +5
  - Terremoto (dano +10, 50% chance de atordoar)
- *Destreza:* 3
- *Vantagens:* Criatura
- *Desvantagens:* Monstro

### Mago
- *Pontos de Vida:* 20
- *Dano:* 5
- *Propriedades:*
  - 10% chance de carregar pontos de habilidade +5
  - Começa com 10 pontos de habilidade
  - Começa com 5 de defesa
- *Habilidades:*
  - Tempestade (dano +15, elemento Água)
  - Tornado (dano +10, 30% chance de atordoar, elemento Ar)
- *Destreza:* 2
- *Vantagens:* Incorpóreo
- *Desvantagens:* Criatura

## Inimigos

### Aranha Gigante
- *Pontos de Vida:* 20
- *Dano:* 7
- *Propriedades:* 30% chance de envenenamento
- *Destreza:* 3
- *Vantagens:* Ar
- *Desvantagens:* Fogo

### Banshee
- *Pontos de Vida:* 25
- *Dano:* 5
- *Propriedades:* 20% chance de atordoar
- *Destreza:* 5
- *Vantagens:* Terra
- *Desvantagens:* Ar

### Demônio
- *Pontos de Vida:* 20
- *Dano:* 10
- *Propriedades:* 20% chance de queimadura
- *Destreza:* 3
- *Vantagens:* Fogo
- *Desvantagens:* Água

### Troll
- *Pontos de Vida:* 50
- *Dano:* 5
- *Propriedades:* 5% chance de adormecer em combate (ele mesmo)
- *Destreza:* 0
- *Vantagens:* Terra
- *Desvantagens:* (nenhuma)

## Efeitos de Combate
- *Envenenado:* a cada rodada o personagem envenenado sofre 2 de dano.
- *Atordoado:* o personagem atordoado fica 1 turno sem atacar.
- *Queimado:* a cada rodada o personagem queimado sofre 1 de dano.
- *Adormecido:* o personagem que estiver adormecido não joga até sofrer um ataque.

A habilidade Cura da classe Druida retira todos os efeitos de combate do personagem curado.
