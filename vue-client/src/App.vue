<template>
  <div id="app">
    <nav class="navbar navbar-expand" style="background-color: #e3f2fd;">
      <a href="#" class="navbar-brand">Video Notes</a>
      <div class="navbar-nav mr-auto">
      </div>
      <form class="form-inline">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
    </nav>

    <div class="container mt-3">
      <router-view />
    </div>
  </div>
</template>

<script>
  export default {
    name: 'app'
  }
</script>
