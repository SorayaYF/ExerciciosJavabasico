select * from cargo;

select nome, qt_vereadores from cidade order by nome;

select nome, qt_vereadores from cidade where qt_vereadores > 9;

select count(*) from cidade where qt_vereadores > 9;

select max(qt_vereadores) from cidade;

select c.nome as cidades from cidade c where qt_vereadores = (select max(qt_vereadores) from cidade);

select ca.nome as candidatos from candidato ca inner join cargo c on ca.cargo = c.id where c.nome = 'Prefeito' order by ca.nome;

select ca.nome as candidatos from candidato ca inner join cargo c on ca.cargo = c.id where c.nome = 'Vereador' and ca.nome like '%MARIA %' order by ca.nome;

select ca.nome as candidatos from candidato ca inner join cargo c on ca.cargo = c.id where c.nome = 'Vereador' and ca.nome like 'Y%' order by ca.nome;

select c.nome as cidades, ca.nome as candidatos from candidato ca inner join cidade c on ca.cidade = c.id inner join cargo cr on ca.cargo = cr.id where cr.nome = 'Prefeito' order by c.nome, ca.nome;

select ca.nome as candidatos from candidato ca inner join cidade c on ca.cidade = c.id inner join cargo cr on ca.cargo = cr.id where cr.nome = 'Prefeito' and c.nome = 'TUBARÃO' order by ca.nome;

select ca.nome as candidatos from candidato ca inner join cidade c on ca.cidade = c.id inner join cargo cr on ca.cargo = cr.id where cr.nome = 'Prefeito' and c.qt_eleitores = (SELECT MAX(qt_eleitores) FROM cidade) order by ca.nome;

select count(*) as quantidade from candidato ca inner join cidade c on ca.cidade = c.id inner join cargo cr on ca.cargo = cr.id where cr.nome = 'Vereador' and c.nome = 'TUBARÃO';

select c.nome, count(*) as quantidade from candidato ca inner join cidade c on ca.cidade = c.id inner join cargo cr on ca.cargo = cr.id where cr.nome = 'Vereador' group by c.nome order by c.nome;

select sum(vi.brancos) as brancos, sum(vi.nulos) as nulos from voto_invalido vi inner join cidade c on vi.cidade = c.id inner join cargo cr on vi.cargo = cr.id where cr.nome = 'Prefeito' and c.nome = 'TUBARÃO';

select sum(vi.brancos + vi.nulos) as votos_invalidos from voto_invalido vi inner join cidade c on vi.cidade = c.id inner join cargo cr on vi.cargo = cr.id where cr.nome = 'Prefeito' and c.nome = 'TUBARÃO';

select ca.nome, count(*) quantidade 
from voto v 
inner join candidato ca on v.candidato = ca.id 
inner join cidade c on ca.cidade = c.id 
inner join cargo cr on ca.cargo = cr.id 
where cr.nome  = 'Prefeito' and c.nome = 'TUBARÃO' group by ca.nome order by quantidade DESC;

select ca.nome, count(v.id) quantidade 
from voto v 
inner join candidato ca on v.candidato = ca.id 
inner join cidade c on ca.cidade = c.id 
inner join cargo cr on ca.cargo = cr.id 
where cr.nome  = 'Vereador' and c.nome = 'TUBARÃO' 
group by ca.nome order by quantidade DESC;

select p.sigla, COUNT(*) quantidade from voto v inner join candidato ca on v.candidato = ca.id inner join partido p on ca.partido = p.id inner join cidade c on ca.cidade = c.id where c.nome = 'TUBARÃO' group by p.sigla order by quantidade desc;
