document.addEventListener('DOMContentLoaded', function() {
    fetchJogadores();
    fetchPartidas(0, 10);
    fetchUltimosResultados();
    fetchJogadoresPontos();

    const partidaForm = document.getElementById('partidaForm');
    partidaForm.addEventListener('submit', function(event) {
        event.preventDefault();
        registrarPartida();
    });

    const nextPageButton = document.getElementById('nextPage');
    nextPageButton.addEventListener('click', function() {
        const currentPage = parseInt(nextPageButton.dataset.page);
        fetchPartidas(currentPage + 1, 10);
    });

    const prevPageButton = document.getElementById('prevPage');
    prevPageButton.addEventListener('click', function() {
        const currentPage = parseInt(prevPageButton.dataset.page);
        if (currentPage > 0) {
            fetchPartidas(currentPage - 1, 10);
        }
    });
});

function fetchJogadores() {
    fetch('/api/jogadores/nomes')
        .then(response => response.json())
        .then(data => {
            const jogador1Select = document.getElementById('jogador1');
            const jogador2Select = document.getElementById('jogador2');
            data.forEach(nome => {
                const option1 = document.createElement('option');
                option1.value = nome;
                option1.textContent = nome;
                jogador1Select.appendChild(option1);

                const option2 = document.createElement('option');
                option2.value = nome;
                option2.textContent = nome;
                jogador2Select.appendChild(option2);
            });
        })
        .catch(error => console.error('Erro ao buscar jogadores:', error));
}

function fetchPartidas(page, size) {
    fetch(`/api/partidas/resultados?page=${page}&size=${size}`)
        .then(response => response.json())
        .then(data => {
            const resultadosTable = document.getElementById('resultadosTable').getElementsByTagName('tbody')[0];
            resultadosTable.innerHTML = '';

            data.content.forEach(partida => {
                const row = resultadosTable.insertRow();
                const cellNome1 = row.insertCell(0);
                const cellTime1 = row.insertCell(1);
                const cellNome2 = row.insertCell(2);
                const cellTime2 = row.insertCell(3);
                const cellPlacar = row.insertCell(4);
                const cellResultado = row.insertCell(5);

                cellNome1.textContent = partida.jogador1;
                cellTime1.textContent = partida.timeJogador1;
                cellNome2.textContent = partida.jogador2;
                cellTime2.textContent = partida.timeJogador2;
                cellPlacar.textContent = `${partida.placarJogador1} X ${partida.placarJogador2}`;

                if (partida.placarJogador1 > partida.placarJogador2) {
                    cellResultado.textContent = `${partida.jogador1} Venceu`;
                } else if (partida.placarJogador1 < partida.placarJogador2) {
                    cellResultado.textContent = `${partida.jogador2} Venceu`;
                } else {
                    cellResultado.textContent = 'Empate';
                }
            });

            const nextPageButton = document.getElementById('nextPage');
            const prevPageButton = document.getElementById('prevPage');

            if (data.totalElements > 10) {
                nextPageButton.style.display = 'inline-block';
                prevPageButton.style.display = 'inline-block';
            } else {
                nextPageButton.style.display = 'none';
                prevPageButton.style.display = 'none';
            }

            nextPageButton.dataset.page = data.number;
            prevPageButton.dataset.page = data.number;
        })
        .catch(error => console.error('Erro ao buscar partidas:', error));
}

function registrarPartida() {
    const jogador1 = document.getElementById('jogador1').value;
    const jogador2 = document.getElementById('jogador2').value;
    const timeJogador1 = document.getElementById('timeJogador1').value;
    const timeJogador2 = document.getElementById('timeJogador2').value;
    const placarJogador1 = document.getElementById('placarJogador1').value;
    const placarJogador2 = document.getElementById('placarJogador2').value;

    const partida = {
        jogador1: jogador1,
        jogador2: jogador2,
        timeJogador1: timeJogador1,
        timeJogador2: timeJogador2,
        placarJogador1: parseInt(placarJogador1),
        placarJogador2: parseInt(placarJogador2)
    };

    fetch('/api/partidas/registrar', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(partida)
    })
    .then(response => {
        if (response.ok) {
            alert('Partida registrada com sucesso!');
            fetchPartidas(0, 10);
        } else {
            alert('Erro ao registrar partida.');
        }
    })
    .catch(error => console.error('Erro ao registrar partida:', error));
}

function fetchUltimosResultados() {
    fetch('/api/partidas/ultimos')
        .then(response => response.json())
        .then(data => {
            const resultadosContainer = document.getElementById('resultadosContainer');
            resultadosContainer.innerHTML = '';

            data.forEach(partida => {
                const resultBox = document.createElement('div');
                resultBox.className = 'result-box';

                const matchDiv = document.createElement('div');
                matchDiv.className = 'match';

                const matchInfo = document.createElement('p');
                matchInfo.textContent = `${partida.jogador1} (${partida.timeJogador1}) ${partida.placarJogador1} - ${partida.placarJogador2} ${partida.jogador2} (${partida.timeJogador2})`;
                matchDiv.appendChild(matchInfo);

                resultBox.appendChild(matchDiv);
                resultadosContainer.appendChild(resultBox);
            });
        })
        .catch(error => console.error('Erro ao buscar últimos resultados:', error));
}

function fetchJogadoresPontos() {
    fetch('/api/jogadores/pontos')
        .then(response => response.json())
        .then(data => {
            const jogadoresTable = document.getElementById('jogadoresTable').getElementsByTagName('tbody')[0];
            jogadoresTable.innerHTML = '';

            data.forEach(jogador => {
                const row = jogadoresTable.insertRow();
                const cellNome = row.insertCell(0);
                const cellPontos = row.insertCell(1);

                cellNome.textContent = jogador.nome;
                cellPontos.textContent = jogador.pontos;
            });
        })
        .catch(error => console.error('Erro ao buscar jogadores e pontos:', error));
}