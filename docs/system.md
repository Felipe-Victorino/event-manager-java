# ISOLA: Sistema de Gestão de Eventos Corporativos
#### Felipe F. L.Victorino, Frank W. C. de Oliveira



Crie um sistema para organizar conferências e eventos. Permite cadastrar sessões, salas e palestrantes, controlar inscrições e participação de participantes, evitar conflitos de agenda, emitir crachás e coletar feedback. Deve gerar relatórios de comparecimento, ocupação por sala e avaliação média dos palestrantes.

Possíveis classes de domínio/entidade. Evento, Participante, Palestrante, Sessao, Sala, Inscricao, Feedback.

Possíveis estruturas de dados. Árvore de intervalos (agenda de sessões), lista encadeada (participantes de uma sessão), grafo (ligações entre palestrantes e sessões).

## Persistência

O banco de dados utilizado será o MariaDB, conectado via o Persistence e Maven

Os eventos e suas sessões passadas e futuras deverão ser armazenados, eles serão utilizados para formar uma agenda, palestrantes e usuário também serão cadastrados.
Salas também serão registradas e cadastradas no banco de dados
Relatórios não serão persistidos em base de dados, mas a geração de um documento de texto com as informações será gerado com base nas avaliações do banco.

## Regras de Negócio e Funcionalidades
- O sistema utilizará uma interface gráfica com Swing.
- A interface gráfica terá
- Para verificar a disponibilidade de tempo e horário diário, uma árvore de intervalo será utilizada.

- A descrição dos eventos terá um limite de 250 caracteres.
- Não permitir cadastro de sessões simultâneas na mesma Sala.
- Não permitir um palestrante estar simultaneamente em duas salas no mesmo período.
- Não permitir um participante estar em duas sessões ao mesmo tempo