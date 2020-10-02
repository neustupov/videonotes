<template>
  <div class="container">
    <div class="row float-left">
      <div class="col-md-auto align-self-center">
        <div class="row justify-content-md-center">
          <a href="/add" class="btn btn-outline-primary btn-sm m-1" role="button"
             aria-pressed="true">Add board</a>
        </div>
        <div v-if="currentBoard">
          <div class="row justify-content-md-center center-block">
            <button href="#" type="button" class="btn btn-outline-primary btn-sm m-1">Edit board
            </button>
          </div>
        </div>
      </div>
      <div class="col">
        <Boards @set-current-board="setCurrentBoard"/>
      </div>
    </div>
    <div class="row float-left">
      <div class="col-md-auto align-self-center">
        <Stickers/>
      </div>
    </div>
  </div>
</template>

<script>
  import Boards from "./Boards";
  import Stickers from "./Stickers";

  export default {
    name: "Main",
    components: {Boards, Stickers},
    data() {
      return {
        currentBoard: null
      }
    },
    methods: {
      setCurrentBoard(board) {
        this.currentBoard = board;
        console.log(board)
      }
    }
  }
</script>

<style scoped>

</style>