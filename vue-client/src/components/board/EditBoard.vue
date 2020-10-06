<template>
  <div class="submit-form">
    <div class="form-group">
      <label for="title">Title</label>
      <input
          type="text"
          class="form-control"
          id="title"
          required
          v-model="board.title"
          name="title"
      />
    </div>
    <button @click="editBoard" class="btn btn-success">Submit</button>
  </div>
</template>

<script>
  import BoardDataService from "../../services/BoardDataService";

  export default {
    name: "edit-board",
    data() {
      return {
        board: {
          id: null,
          title: ""
        }
      };
    },
    methods: {
      editBoard() {
        var data = {
          title: this.board.title,
        };

        BoardDataService.update(this.$route.params.id, data)
        .then(response => {
          this.board.id = response.data.id;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
      },

      newBoard() {
        this.board = {};
      }
    }
  };
</script>

<style>
  .submit-form {
    max-width: 300px;
    margin: auto;
  }
</style>