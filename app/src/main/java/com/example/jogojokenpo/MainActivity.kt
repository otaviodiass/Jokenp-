package com.example.jogojokenpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.jogojokenpo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit var binding: ActivityMainBinding
    var placarPlayer: Int = 0
    var placarCpu: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        configuraInicio()

    }

    private fun configuraInicio(){
        binding.tesouraBtn.setOnClickListener(this)
        binding.pedraBtn.setOnClickListener(this)
        binding.papelBtn.setOnClickListener(this)
        binding.novoJogoBtn.setOnClickListener(this)
    }

    override fun onClick(botao: View) {

        when(botao.id){
            binding.tesouraBtn.id-> {
                escolhaTesoura("Tesoura")
            }
            binding.pedraBtn.id-> {
                escolhaPedra("Pedra")
            }
            binding.papelBtn.id-> {
                esolhaPapel("Papel")
            }
            binding.novoJogoBtn.id-> {
                novoJogo()
            }
        }
    }

    private fun sorteiaCPU(): String {
        val listaOpcoes: List<String> = listOf("Tesoura", "Pedra", "Papel")
        var valor: String = listaOpcoes.random()
        return valor
    }

    private fun escolhaTesoura(escolha: String){

        var escolhaCpu: String = sorteiaCPU()

        if (escolha == escolhaCpu){
            binding.escolhaPlayerTxt.setText(escolha)
            binding.opcaoCpuTxt.setText(escolhaCpu)
        } else if(escolhaCpu == "Pedra"){
            binding.escolhaPlayerTxt.setText(escolha)
            binding.opcaoCpuTxt.setText(escolhaCpu)
            placarCpu += 1
            binding.resultadoCpuTxt.setText(placarCpu.toString())
        } else if (escolhaCpu == "Papel") {
            binding.escolhaPlayerTxt.setText(escolha)
            binding.opcaoCpuTxt.setText(escolhaCpu)
            placarPlayer += 1
            binding.resultadoPlayerTxt.setText(placarPlayer.toString())
        }
    }

    private fun escolhaPedra(escolha: String){

        var escolhaCpu: String = sorteiaCPU()

        if (escolha == escolhaCpu){
            binding.escolhaPlayerTxt.setText(escolha)
            binding.opcaoCpuTxt.setText(escolhaCpu)
        } else if(escolhaCpu == "Papel"){
            binding.escolhaPlayerTxt.setText(escolha)
            binding.opcaoCpuTxt.setText(escolhaCpu)
            placarCpu += 1
            binding.resultadoCpuTxt.setText(placarCpu.toString())
        } else if (escolhaCpu == "Tesoura"){
            binding.escolhaPlayerTxt.setText(escolha)
            binding.opcaoCpuTxt.setText(escolhaCpu)
            placarPlayer += 1
            binding.resultadoPlayerTxt.setText(placarPlayer.toString())
        }
    }

    private fun esolhaPapel(escolha: String) {

        var escolhaCpu: String = sorteiaCPU()

        if (escolha == escolhaCpu) {
            binding.escolhaPlayerTxt.setText(escolha)
            binding.opcaoCpuTxt.setText(escolhaCpu)

        } else if (escolhaCpu == "Tesoura") {
            binding.escolhaPlayerTxt.setText(escolha)
            binding.opcaoCpuTxt.setText(escolhaCpu)
            placarCpu += 1
            binding.resultadoCpuTxt.setText(placarCpu.toString())
        } else if (escolhaCpu == "Pedra"){
            binding.escolhaPlayerTxt.setText(escolha)
            binding.opcaoCpuTxt.setText(escolhaCpu)
            placarPlayer += 1
            binding.resultadoPlayerTxt.setText(placarPlayer.toString())
        }
    }

    private fun novoJogo(){
        placarPlayer = 0
        placarCpu = 0

        binding.resultadoPlayerTxt.setText(placarPlayer.toString())
        binding.resultadoCpuTxt.setText(placarCpu.toString())
        binding.escolhaPlayerTxt.setText("-")
        binding.opcaoCpuTxt.setText("-")
    }
}