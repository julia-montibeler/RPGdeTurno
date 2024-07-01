<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Jogo de RPG - Informações dos Personagens e Inimigos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }
        h2 {
            font-size: 24px;
            margin-bottom: 10px;
            border-bottom: 1px solid #ccc;
            padding-bottom: 5px;
        }
        h3 {
            font-size: 18px;
            margin-bottom: 8px;
        }
        h4 {
            font-weight: normal;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        li {
            margin-bottom: 5px;
        }
        .personagem {
            margin-bottom: 20px;
        }
        .inimigo {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <h1>Jogo de RPG - Informações das Classes e Inimigos</h1>
    <div class="personagem">
        <h2>Classes:</h2>
        <h4>Pontos de habilidade são os pontos necessários para uma classe utilizar uma habilidade, cada habilidade gasta 5 pontos, a cada 3 rodadas os pontos de habilidades de todos são recarregados.</h4>
        <h4>Por padrão todas as classes começam com 5 pontos de habilidade (exceto Mago), cada personagem pode acumular até 10 pontos de habilidade</h4>

        <div class="barbaro">
            <h3>Barbaro</h3>
            <ul>
                <li><strong>Pontos de Vida:</strong> 25</li>
                <li><strong>Dano:</strong> 10</li>
                <li><strong>Propriedades:</strong> 10% chance crítico ao atacar</li>
                <li><strong>Habilidades:</strong>(nenhuma)</li>
                <li><strong>Destreza:</strong> 0</li>
                <li><strong>Vantagens:</strong> (nenhuma)</li>
                <li><strong>Desvantagens:</strong> Incorpóreo</li>
            </ul>
        </div>

        <div class="arqueiro">
            <h3>Arqueiro</h3>
            <ul>
                <li><strong>Pontos de Vida:</strong> 20</li>
                <li><strong>Dano:</strong> 3</li>
                <li><strong>Propriedades:</strong> 10% esquivar quando atacado</li>
                <li><strong>Habilidades:</strong>
                    <ul>
                        <li>Flecha de fogo (dano +10, 50% chance de queimadura)</li>
                    </ul>
                </li>
                <li><strong>Destreza:</strong> 5</li>
                <li><strong>Vantagens:</strong> Monstro</li>
                <li><strong>Desvantagens:</strong> Incorpóreo</li>
            </ul>
        </div>

        <div class="druida">
            <h3>Druida</h3>
            <ul>
                <li><strong>Pontos de Vida:</strong>25</li>
                <li><strong>Dano:</strong> 5</li>
                <li><strong>Propriedades:</strong> 10% chance de cura +5</li>
                <li><strong>Habilidades:</strong>
                    <ul>
                        <li>Cura +5</li>
                        <li>Terremoto (dano +10, 50% chance de atordoar)</li>
                    </ul>
                </li>
                <li><strong>Destreza:</strong> 3</li>
                <li><strong>Vantagens:</strong> Criatura</li>
                <li><strong>Desvantagens:</strong> Monstro</li>
            </ul>
        </div>

        <div class="mago">
            <h3>Mago</h3>
            <ul>
                <li><strong>Pontos de Vida:</strong> 20</li>
                <li><strong>Dano:</strong> 5</li>
                <li><strong>Propriedades:</strong> 
                    <ul>10% chance de carregar pontos de Habilidade +5</ul>
                    <ul>Começa com 10 pontos de habilidade</ul>
                    <ul>Começa com 5 de defesa</ul>
                </li>
                <li><strong>Habilidades:</strong>
                    <ul>
                        <li>Tempestade (dano +15, elemento Água)</li>
                        <li>Tornado (dano +10, 30% chance de atordoar, elemento Ar)</li>
                    </ul>
                </li>
                <li><strong>Destreza:</strong> 2</li>
                <li><strong>Vantagens:</strong> Incorpóreo</li>
                <li><strong>Desvantagens:</strong> Criatura</li>
            </ul>
        </div>

    </div>

    <div class="inimigo">
        <h2>Inimigos:</h2>

        <div class="aranha-gigante">
            <h3>Aranha Gigante</h3>
            <ul>
                <li><strong>Pontos de Vida:</strong> 20</li>
                <li><strong>Dano:</strong> 7</li>
                <li><strong>Propriedades:</strong> 30% chance de envenenamento</li>
                <li><strong>Destreza:</strong> 3</li>
                <li><strong>Vantagens:</strong> Ar</li>
                <li><strong>Desvantagens:</strong> Fogo</li>
            </ul>
        </div>

        <div class="banshee">
            <h3>Banshee</h3>
            <ul>
                <li><strong>Pontos de Vida:</strong> 25</li>
                <li><strong>Dano:</strong> 5</li>
                <li><strong>Propriedades:</strong> 20% chance de atordoar</li>
                <li><strong>Destreza:</strong> 5</li>
                <li><strong>Vantagens:</strong> Terra</li>
                <li><strong>Desvantagens:</strong> Ar</li>
            </ul>
        </div>

        <div class="demonio">
            <h3>Demônio</h3>
            <ul>
                <li><strong>Pontos de Vida:</strong> 20</li>
                <li><strong>Dano:</strong> 10</li>
                <li><strong>Propriedades:</strong> 20% chance de queimadura</li>
                <li><strong>Destreza:</strong> 3</li>
                <li><strong>Vantagens:</strong> Fogo</li>
                <li><strong>Desvantagens:</strong> Água</li>
            </ul>
        </div>

        <div class="troll">
            <h3>Troll</h3>
            <ul>
                <li><strong>Pontos de Vida:</strong> 50</li>
                <li><strong>Dano:</strong> 5</li>
                <li><strong>Propriedades:</strong> 5% chance de adormecer em combate (ele mesmo)</li>
                <li><strong>Destreza:</strong> 0</li>
                <li><strong>Vantagens:</strong> Terra</li>
                <li><strong>Desvantagens:</strong> (nenhuma)</li>
            </ul>
        </div>

    </div>

    <div class="efeitoCombate">
        <h2>Efeitos de combate:</h2>
        <ul>
            <li>Envenenado: a cada rodada o personagem envenenado sofre 2 de dano</li>
            <li>Atordoado: o personagem atordoado fica 1 turno sem atacar</li>
            <li>Queimado: a cada rodada o personagem queimado sofre 1 de dano</li>
            <li>Adormecido: o personagem que estiver adormecido não joga até sofrer um ataque</li>
        </ul>
        <p>A habilidade Cura da classe Druida retira todos os efeitos de combate do personagem curado</p>
    </div>

</body>
</html>
