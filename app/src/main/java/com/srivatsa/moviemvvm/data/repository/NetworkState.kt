package com.srivatsa.moviemvvm.data.repository

enum class status{
    RUNNING,
    SUCCESS,
    FAILURE
}
class NetworkState(val status:status, val msg:String) {

    companion object{
        val LOADED: NetworkState
        val LOADING: NetworkState
        val ERROR: NetworkState

        init {
            LOADED= NetworkState(status.SUCCESS,"Success")
            LOADING=NetworkState(status.RUNNING,"Running")
            ERROR= NetworkState(status.FAILURE,"something went wrong")
        }
    }

}