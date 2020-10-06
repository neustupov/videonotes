<template>
  <div class="row">
        {{ note.description }}
    </div>
</template>

<script>

  export default {
    name: "note",
    props: ['note'],
    data() {
      return {};
    },
    methods: {
    },
    mounted() {
      console.log(this.sticker);
    }
  };
</script>