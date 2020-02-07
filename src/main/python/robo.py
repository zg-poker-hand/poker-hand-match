'''
Pre-requisitos: python3
instalar pacotes python:
 sudo pip3 install flask flask-jsonpify flask-sqlalchemy flask-restful

Usagem:
executar no terminal:
 python3 robo.py
Mandar um get em: http://localhost:8080/buscargames
os arquivos serao baixados e salvos na pasta resources/web-files
'''

from flask import Flask
from flask_restful import Resource, Api
import requests
import re
import os

app = Flask(__name__)
api = Api(app)

site = 'http://172.22.1.41:8080/poker-game/arquivo'
cookies = ''
caminho_resources = '../resources/web-files'

class Robo(Resource):
    def get(self):
        return self.buscar_cartas()

    def buscar_cartas(self):
        if not os.path.exists(caminho_resources):
            os.makedirs(caminho_resources)

        global cookies
        #abrindo pagina inicial
        r = self.acessar_pagina(site + '/index')

        #coletando links das datas
        conteudo = r.text.replace('\n', '')
        paginas = re.findall('(?<=\/poker-game\/arquivo)([^"]+)(?=">)', conteudo)
        paginas = sorted(set(paginas))
        cookies = r.cookies
        #acessando paginas para pegar os links dos arquivos
        links = []

        for pagina in paginas:
            cookies = ''
            r = self.acessar_pagina(site + '/index')
            cookies = r.cookies
            r = self.acessar_pagina(site + pagina)
            conteudo = r.text.replace('\n', '')
            links = re.findall('(?<=\/poker-game\/arquivo\/arquivo\?id=)([^=\/"]+)', conteudo)
            nomes = re.findall('(HH[^ ]+ [^ ]+)', conteudo)
            print('Size links: {} size nomes: {}'.format(len(links), len(nomes)))
            for link, nome in zip(links, nomes):
                cookies = ''
                r = self.acessar_pagina(site + '/index')
                cookies = r.cookies
                r = self.acessar_pagina(site + '/arquivo?id=' + link)

                self.salvar_arquivo(nome, r.content)

        return "OK"


    def acessar_pagina(self, pagina):
        r = requests.get(pagina, cookies=cookies)
        if r.status_code == 200:
            print("Pagina: {} aberta com sucesso\ncookies: {}".format(pagina, cookies))
        else:
            print("Erro ao abrir pagina " + pagina)
        return r

    def salvar_arquivo(self, nomeArquivo, conteudo):
        arq = caminho_resources + '/' + nomeArquivo
        with open(arq, 'wb') as f:
            f.write(conteudo)
        print("Arquivo salvo em {}".format(arq))



api.add_resource(Robo, '/buscargames')  # Route_1

if __name__ == '__main__':
    app.run(port=5002)