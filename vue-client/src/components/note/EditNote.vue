<template>
  <div class="submit-form">
    <div class="form-group">
      <label for="description">Description</label>
      <input
          type="text"
          class="form-control"
          id="description"
          required
          v-model="note.description"
          name="description"
      />
    </div>
    <button @click="editNote" class="btn btn-success">Submit</button>
  </div>
</template>

<script>
  import NoteDataService from "../../services/NoteDataService";

  export default {
    name: "edit-Note",
    data() {
      return {
        note: {
          id: null,
          description: ""
        }
      };
    },
    methods: {
      editNote() {
        var data = {
          description: this.note.description,
        };

        NoteDataService.update(this.$route.params.id, data)
        .then(response => {
          this.note.id = response.data.id;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
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