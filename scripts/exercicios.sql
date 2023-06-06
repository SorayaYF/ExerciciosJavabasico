select * from cargo;

select nome, qt_vereadores from cidade order by nome;

select nome, qt_vereadores from cidade where qt_vereadores > 9;

select count(*) from cidade where qt_vereadores > 9;

select max(qt_vereadores) from cidade;

select c.nome cidades from cidade c where qt_vereadores = (select max(qt_vereadores) from cidade);

select ca.nome candidatos from candidato ca inner join cargo c on ca.cargo = c.id where c.nome = 'Prefeito' order by ca.nome;

select ca.nome candidatos from candidato ca inner join cargo c on ca.cargo = c.id where c.nome = 'Vereador' and ca.nome like '%MARIA%' order by ca.nome;

select ca.nome candidatos from candidato ca inner join cargo c on ca.cargo = c.id where c.nome = 'Vereador' and ca.nome like 'Y%' order by ca.nome;

select c.nome cidades, ca.nome candidatos from candidato ca inner join cidade c on ca.cidade = c.id inner join cargo cr on ca.cargo = cr.id where cr.nome = 'Prefeito' order by c.nome, ca.nome;

select ca.nome candidatos from candidato ca inner join cidade c on ca.cidade = c.id inner join cargo cr on ca.cargo = cr.id where cr.nome = 'Prefeito' and c.nome = 'TUBARÃO' order by ca.nome;

select ca.nome candidatos from candidato ca inner join cidade c on ca.cidade = c.id inner join cargo cr on ca.cargo = cr.id where cr.nome = 'Prefeito' and c.qt_eleitores = (SELECT MAX(qt_eleitores) FROM cidade) order by ca.nome;

select count(*) quantidade from candidato ca inner join cidade c on ca.cidade = c.id inner join cargo cr on ca.cargo = cr.id where cr.nome = 'Vereador' and c.nome = 'TUBARÃO';

select c.nome, count(*) quantidade from candidato ca inner join cidade c on ca.cidade = c.id inner join cargo cr on ca.cargo = cr.id where cr.nome = 'Vereador' group by c.nome order by c.nome;

select cr.nome, sum(vi.brancos) brancos, sum(vi.nulos) nulos from voto_invalido vi inner join cidade c on vi.cidade = c.id inner join cargo cr on vi.cargo = cr.id where c.nome = 'TUBARÃO' group by cr.nome;

select sum(vi.brancos) + sum(vi.nulos) votos_invalidos from voto_invalido vi inner join cidade c on vi.cidade = c.id inner join cargo cr on vi.cargo = cr.id where cr.nome = 'Prefeito' and c.nome = 'TUBARÃO';

select ca.nome, count(*) quantidade 
from voto v 
inner join candidato ca on v.candidato = ca.id 
inner join cidade c on ca.cidade = c.id 
inner join cargo cr on ca.cargo = cr.id 
where cr.nome  = 'Prefeito' and c.nome = 'TUBARÃO' group by ca.nome order by quantidade DESC;

select candidato.nome, voto.voto votos
from candidato 
inner join voto on voto.candidato = candidato.id
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
order by votos desc;

select candidato.nome, voto.voto votos
from candidato 
inner join voto on voto.candidato = candidato.id
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Vereador'
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
order by votos desc;

select cidade.nome, max(voto.voto)
from cidade 
inner join candidato on candidato.cidade = cidade.id
inner join voto on voto.candidato = candidato.id
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
group by cidade.nome;

select p.sigla, sum(v.voto) quantidade from voto v inner join candidato ca on v.candidato = ca.id inner join partido p on ca.partido = p.id inner join cidade c on ca.cidade = c.id where c.nome = 'TUBARÃO' group by p.sigla order by quantidade desc;

select sum(voto.voto + voto_invalido.nulos + voto_invalido.brancos)
from voto
inner join candidato on candidato.id = voto.candidato 
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO' 
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
inner join voto_invalido on voto_invalido.cidade = cidade.id and voto_invalido.cargo = cargo.id

select sum(voto.voto + voto_invalido.nulos + voto_invalido.brancos)
from voto
inner join candidato on candidato.id = voto.candidato 
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO' 
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
inner join voto_invalido on voto_invalido.cidade = cidade.id and voto_invalido.cargo = cargo.id

select sum(cidade.qt_eleitores - voto.voto + voto_invalido.nulos + voto_invalido.brancos)
from voto
inner join candidato on candidato.id = voto.candidato 
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO' 
inner join cargo on cargo.id = candidato.cargo
inner join voto_invalido on voto_invalido.cidade = cidade.id and voto_invalido.cargo = cargo.id



select cidade.nome, sum(cidade.qt_eleitores - voto.voto + voto_invalido.nulos + voto_invalido.brancos)
from voto
inner join candidato on candidato.id = voto.candidato 
inner join cidade on cidade.id = candidato.cidade
inner join cargo on cargo.id = candidato.cargo
inner join voto_invalido on voto_invalido.cidade = cidade.id and voto_invalido.cargo = cargo.id
group by cidade.nome

select cidade.nome, (count(voto.voto)::float / cidade.qt_eleitores * 100) percentual_faltantes
from cidade
inner join candidato on candidato.cidade = cidade.id 
inner join voto on candidato.id = voto.candidato 
group by cidade.nome, cidade.qt_eleitores
order by percentual_faltantes desc;

select cidade.nome, candidato.nome
from candidato
inner join cidade on candidato.cidade = cidade.id
where candidato.cargo = (select id from cargo where nome = 'Prefeito')
  and candidato.id = (
    select candidato
    from voto
    where candidato in (
      select id
      from candidato
      where candidato.cargo = (select id from cargo where nome = 'Prefeito')
      and candidato.cidade = cidade.id
    )
    group by candidato
    order by COUNT(*) desc
    limit 1
  )
order by cidade.nome;



