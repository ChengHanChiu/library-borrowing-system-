<script setup>
import {useRouter} from 'vue-router'
import {ref, onMounted} from 'vue'

import ApiService from '@/service/ApiService'
import InventoryRow from '@/components/InventoryRow.vue';
import BookInfo from '@/components/BookInfo.vue';

const router = useRouter()

const inventoryData = ref([]);

const getInventory = async () => {
  try {
    const response = await ApiService.get('/inventory');
    if (response.status==200){
      return response.data
    };
  } catch (error) {
    console.error(error); 
  }
}

const showBookInfo = ref(false);
const bookData = ref(null);
const handleShow = (data) => {
  bookData.value = data; 
  showBookInfo.value = true; 
};

onMounted(async() => {
  const isLoggedIn = false
  if (!isLoggedIn) {
    // router.push('/login'); 
  }
  const temp =  await getInventory();
  inventoryData.value = temp._embedded.inventoryList
  
});



</script>

<template>
  <header id="header" class="header fixed-top d-flex align-items-center">

  <div class="d-flex align-items-center justify-content-between">
    <a href="index.html" class="logo d-flex align-items-center">
      <img src="@/assets/logo.svg" alt="">
      <span class="d-none d-lg-block">Library</span>
    </a>
    <i class="bi bi-list toggle-sidebar-btn"></i>
  </div><!-- End Logo -->

  <!-- <div class="search-bar">
    <form class="search-form d-flex align-items-center" method="POST" action="#">
      <input type="text" name="query" placeholder="Search" title="Enter search keyword">
      <button type="submit" title="Search"><i class="bi bi-search"></i></button>
    </form> -->
  <!-- </div>End Search Bar -->

  <nav class="header-nav ms-auto">
    <ul class="d-flex align-items-center">

      <li class="nav-item d-block d-lg-none">
        <a class="nav-link nav-icon search-bar-toggle " href="#">
          <i class="bi bi-search"></i>
        </a>
      </li><!-- End Search Icon-->

      <li class="nav-item dropdown">

        <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
          <i class="bi bi-bell"></i>
          <span class="badge bg-primary badge-number">4</span>
        </a><!-- End Notification Icon -->

        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications">
          <li class="dropdown-header">
            You have 4 new notifications
            <a href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">View all</span></a>
          </li>
          <li>
            <hr class="dropdown-divider">
          </li>

          <li class="notification-item">
            <i class="bi bi-exclamation-circle text-warning"></i>
            <div>
              <h4>Lorem Ipsum</h4>
              <p>Quae dolorem earum veritatis oditseno</p>
              <p>30 min. ago</p>
            </div>
          </li>

          <li>
            <hr class="dropdown-divider">
          </li>

          <li class="notification-item">
            <i class="bi bi-x-circle text-danger"></i>
            <div>
              <h4>Atque rerum nesciunt</h4>
              <p>Quae dolorem earum veritatis oditseno</p>
              <p>1 hr. ago</p>
            </div>
          </li>

          <li>
            <hr class="dropdown-divider">
          </li>

          <li class="notification-item">
            <i class="bi bi-check-circle text-success"></i>
            <div>
              <h4>Sit rerum fuga</h4>
              <p>Quae dolorem earum veritatis oditseno</p>
              <p>2 hrs. ago</p>
            </div>
          </li>

          <li>
            <hr class="dropdown-divider">
          </li>

          <li class="notification-item">
            <i class="bi bi-info-circle text-primary"></i>
            <div>
              <h4>Dicta reprehenderit</h4>
              <p>Quae dolorem earum veritatis oditseno</p>
              <p>4 hrs. ago</p>
            </div>
          </li>

          <li>
            <hr class="dropdown-divider">
          </li>
          <li class="dropdown-footer">
            <a href="#">Show all notifications</a>
          </li>

        </ul><!-- End Notification Dropdown Items -->

      </li><!-- End Notification Nav -->

      <li class="nav-item dropdown">

        <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
          <i class="bi bi-chat-left-text"></i>
          <span class="badge bg-success badge-number">3</span>
        </a><!-- End Messages Icon -->

        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow messages">
          <li class="dropdown-header">
            You have 3 new messages
            <a href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">View all</span></a>
          </li>
          <li>
            <hr class="dropdown-divider">
          </li>

          <li class="message-item">
            <a href="#">
              <img src="" alt="" class="rounded-circle">
              <div>
                <h4>Maria Hudson</h4>
                <p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>
                <p>4 hrs. ago</p>
              </div>
            </a>
          </li>
          <li>
            <hr class="dropdown-divider">
          </li>

          <li class="message-item">
            <a href="#">
              <img src="" alt="" class="rounded-circle">
              <div>
                <h4>Anna Nelson</h4>
                <p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>
                <p>6 hrs. ago</p>
              </div>
            </a>
          </li>
          <li>
            <hr class="dropdown-divider">
          </li>

          <li class="message-item">
            <a href="#">
              <img src="" alt="" class="rounded-circle">
              <div>
                <h4>David Muldon</h4>
                <p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>
                <p>8 hrs. ago</p>
              </div>
            </a>
          </li>
          <li>
            <hr class="dropdown-divider">
          </li>

          <li class="dropdown-footer">
            <a href="#">Show all messages</a>
          </li>

        </ul><!-- End Messages Dropdown Items -->

      </li><!-- End Messages Nav -->

      <li class="nav-item dropdown pe-3">

        <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
          <img src="" alt="Profile" class="rounded-circle">
          <span class="d-none d-md-block dropdown-toggle ps-2">K. Anderson</span>
        </a><!-- End Profile Iamge Icon -->

        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
          <li class="dropdown-header">
            <h6>Kevin Anderson</h6>
            <span>Web Designer</span>
          </li>
          <li>
            <hr class="dropdown-divider">
          </li>

          <li>
            <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
              <i class="bi bi-person"></i>
              <span>My Profile</span>
            </a>
          </li>
          <li>
            <hr class="dropdown-divider">
          </li>

          <li>
            <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
              <i class="bi bi-gear"></i>
              <span>Account Settings</span>
            </a>
          </li>
          <li>
            <hr class="dropdown-divider">
          </li>

          <li>
            <a class="dropdown-item d-flex align-items-center" href="pages-faq.html">
              <i class="bi bi-question-circle"></i>
              <span>Need Help?</span>
            </a>
          </li>
          <li>
            <hr class="dropdown-divider">
          </li>

          <li>
            <a class="dropdown-item d-flex align-items-center" href="#">
              <i class="bi bi-box-arrow-right"></i>
              <span>Sign Out</span>
            </a>
          </li>

        </ul><!-- End Profile Dropdown Items -->
      </li><!-- End Profile Nav -->

    </ul>
  </nav><!-- End Icons Navigation -->

  </header><!-- End Header -->

  <aside id="sidebar" class="sidebar">

  <ul class="sidebar-nav" id="sidebar-nav">

    <li class="nav-item">
      <a class="nav-link " href="index.html">
        <i class="bi bi-grid"></i>
        <span>Catalog</span>
      </a>
    </li><!-- End Catalog Nav -->

    <li class="nav-item">
      <a class="nav-link collapsed" data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
        <i class="bi bi-menu-button-wide"></i><span>Components</span><i class="bi bi-chevron-down ms-auto"></i>
      </a>
      <ul id="components-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
        <li>
          <a href="components-alerts.html">
            <i class="bi bi-circle"></i><span>Alerts</span>
          </a>
        </li>
        <li>
          <a href="components-accordion.html">
            <i class="bi bi-circle"></i><span>Accordion</span>
          </a>
        </li>
        <li>
          <a href="components-badges.html">
            <i class="bi bi-circle"></i><span>Badges</span>
          </a>
        </li>
        <li>
          <a href="components-breadcrumbs.html">
            <i class="bi bi-circle"></i><span>Breadcrumbs</span>
          </a>
        </li>
        <li>
          <a href="components-buttons.html">
            <i class="bi bi-circle"></i><span>Buttons</span>
          </a>
        </li>
        <li>
          <a href="components-cards.html">
            <i class="bi bi-circle"></i><span>Cards</span>
          </a>
        </li>
        <li>
          <a href="components-carousel.html">
            <i class="bi bi-circle"></i><span>Carousel</span>
          </a>
        </li>
        <li>
          <a href="components-list-group.html">
            <i class="bi bi-circle"></i><span>List group</span>
          </a>
        </li>
        <li>
          <a href="components-modal.html">
            <i class="bi bi-circle"></i><span>Modal</span>
          </a>
        </li>
        <li>
          <a href="components-tabs.html">
            <i class="bi bi-circle"></i><span>Tabs</span>
          </a>
        </li>
        <li>
          <a href="components-pagination.html">
            <i class="bi bi-circle"></i><span>Pagination</span>
          </a>
        </li>
        <li>
          <a href="components-progress.html">
            <i class="bi bi-circle"></i><span>Progress</span>
          </a>
        </li>
        <li>
          <a href="components-spinners.html">
            <i class="bi bi-circle"></i><span>Spinners</span>
          </a>
        </li>
        <li>
          <a href="components-tooltips.html">
            <i class="bi bi-circle"></i><span>Tooltips</span>
          </a>
        </li>
      </ul>
    </li><!-- End Components Nav -->

  <li class="nav-item">
    <a class="nav-link collapsed" data-bs-target="#forms-nav" data-bs-toggle="collapse" href="#">
      <i class="bi bi-journal-text"></i><span>Forms</span><i class="bi bi-chevron-down ms-auto"></i>
    </a>
    <ul id="forms-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
      <li>
        <a href="forms-elements.html">
          <i class="bi bi-circle"></i><span>Form Elements</span>
        </a>
      </li>
      <li>
        <a href="forms-layouts.html">
          <i class="bi bi-circle"></i><span>Form Layouts</span>
        </a>
      </li>
      <li>
        <a href="forms-editors.html">
          <i class="bi bi-circle"></i><span>Form Editors</span>
        </a>
      </li>
      <li>
        <a href="forms-validation.html">
          <i class="bi bi-circle"></i><span>Form Validation</span>
        </a>
      </li>
    </ul>
  </li><!-- End Forms Nav -->

  <li class="nav-item">
    <a class="nav-link collapsed" data-bs-target="#tables-nav" data-bs-toggle="collapse" href="#">
      <i class="bi bi-layout-text-window-reverse"></i><span>Tables</span><i class="bi bi-chevron-down ms-auto"></i>
    </a>
    <ul id="tables-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
      <li>
        <a href="tables-general.html">
          <i class="bi bi-circle"></i><span>General Tables</span>
        </a>
      </li>
      <li>
        <a href="tables-data.html">
          <i class="bi bi-circle"></i><span>Data Tables</span>
        </a>
      </li>
    </ul>
  </li><!-- End Tables Nav -->

  <li class="nav-item">
    <a class="nav-link collapsed" data-bs-target="#charts-nav" data-bs-toggle="collapse" href="#">
      <i class="bi bi-bar-chart"></i><span>Charts</span><i class="bi bi-chevron-down ms-auto"></i>
    </a>
    <ul id="charts-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
      <li>
        <a href="charts-chartjs.html">
          <i class="bi bi-circle"></i><span>Chart.js</span>
        </a>
      </li>
      <li>
        <a href="charts-apexcharts.html">
          <i class="bi bi-circle"></i><span>ApexCharts</span>
        </a>
      </li>
      <li>
        <a href="charts-echarts.html">
          <i class="bi bi-circle"></i><span>ECharts</span>
        </a>
      </li>
    </ul>
  </li><!-- End Charts Nav -->

  <li class="nav-item">
    <a class="nav-link collapsed" data-bs-target="#icons-nav" data-bs-toggle="collapse" href="#">
      <i class="bi bi-gem"></i><span>Icons</span><i class="bi bi-chevron-down ms-auto"></i>
    </a>
    <ul id="icons-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
      <li>
        <a href="icons-bootstrap.html">
          <i class="bi bi-circle"></i><span>Bootstrap Icons</span>
        </a>
      </li>
      <li>
        <a href="icons-remix.html">
          <i class="bi bi-circle"></i><span>Remix Icons</span>
        </a>
      </li>
      <li>
        <a href="icons-boxicons.html">
          <i class="bi bi-circle"></i><span>Boxicons</span>
        </a>
      </li>
    </ul>
  </li><!-- End Icons Nav -->

  <li class="nav-heading">Pages</li>

  <li class="nav-item">
    <a class="nav-link collapsed" href="users-profile.html">
      <i class="bi bi-person"></i>
      <span>Profile</span>
    </a>
  </li><!-- End Profile Page Nav -->

  <li class="nav-item">
    <a class="nav-link collapsed" href="pages-faq.html">
      <i class="bi bi-question-circle"></i>
      <span>F.A.Q</span>
    </a>
  </li><!-- End F.A.Q Page Nav -->

  <li class="nav-item">
    <a class="nav-link collapsed" href="pages-contact.html">
      <i class="bi bi-envelope"></i>
      <span>Contact</span>
    </a>
  </li><!-- End Contact Page Nav -->

  <li class="nav-item">
    <a class="nav-link collapsed" href="pages-register.html">
      <i class="bi bi-card-list"></i>
      <span>Register</span>
    </a>
  </li><!-- End Register Page Nav -->

  <li class="nav-item">
    <a class="nav-link collapsed" href="pages-login.html">
      <i class="bi bi-box-arrow-in-right"></i>
      <span>Login</span>
    </a>
  </li><!-- End Login Page Nav -->

  <li class="nav-item">
    <a class="nav-link collapsed" href="pages-error-404.html">
      <i class="bi bi-dash-circle"></i>
      <span>Error 404</span>
    </a>
  </li><!-- End Error 404 Page Nav -->

  <li class="nav-item">
    <a class="nav-link collapsed" href="pages-blank.html">
      <i class="bi bi-file-earmark"></i>
      <span>Blank</span>
    </a>
  </li><!-- End Blank Page Nav -->

</ul>

  </aside><!-- End Sidebar-->

  <main id="main" class="main">

  <div class="pagetitle">
    <h1>Catalog</h1>
    <nav>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="index.html">Home</a></li>
        <li class="breadcrumb-item active">Catalog</li>
      </ol>
    </nav>
  </div><!-- End Page Title -->

  <section class="section dashboard">
    <div class="row">

      <!-- Left side columns -->
      <div class="col-lg-8">
        <div class="row">

          <!-- Search Bar -->
          <div class="col-12">
            <div class="card">
                <div class="d-flex align-items-center justify-content-between px-3 py-2">
                  <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                  <button class="btn btn-outline-success" type="submit">Search</button>
                </div>
            </div>
          </div><!-- End Search Bar -->

          <!-- Inventory -->
          <div class="col-12">
            <div class="card recent-sales overflow-auto">

              <div class="card-body">
                <h5 class="card-title">Inventory </h5>

                <table class="table table-borderless datatable">
                  <thead>
                    <tr>
                      <th scope="col">#</th>
                      <th scope="col">ISBN</th>
                      <th scope="col">Name</th>
                      <th scope="col">Athor</th>
                      <th scope="col">Status</th>
                    </tr>
                  </thead>
                  <tbody v-for="(item, index) in inventoryData" :key="index">
                      <InventoryRow :data="item" @show="handleShow"/>
          
                    <!-- <tr>
                      <th scope="row"><a href="#">#2457</a></th>
                      <td>Brandon Jacob</td>
                      <td><a href="#" class="text-primary">At praesentium minu</a></td>
                      <td>$64</td>
                      <td><span class="badge bg-success">Approved</span></td>
                    </tr>
                    <tr>
                      <th scope="row"><a href="#">#2147</a></th>
                      <td>Bridie Kessler</td>
                      <td><a href="#" class="text-primary">Blanditiis dolor omnis similique</a></td>
                      <td>$47</td>
                      <td><span class="badge bg-warning">Pending</span></td>
                    </tr>
                    <tr>
                      <th scope="row"><a href="#">#2049</a></th>
                      <td>Ashleigh Langosh</td>
                      <td><a href="#" class="text-primary">At recusandae consectetur</a></td>
                      <td>$147</td>
                      <td><span class="badge bg-success">Approved</span></td>
                    </tr>
                    <tr>
                      <th scope="row"><a href="#">#2644</a></th>
                      <td>Angus Grady</td>
                      <td><a href="#" class="text-primar">Ut voluptatem id earum et</a></td>
                      <td>$67</td>
                      <td><span class="badge bg-danger">Rejected</span></td>
                    </tr>
                    <tr>
                      <th scope="row"><a href="#">#2644</a></th>
                      <td>Raheem Lehner</td>
                      <td><a href="#" class="text-primary">Sunt similique distinctio</a></td>
                      <td>$165</td>
                      <td><span class="badge bg-success">Approved</span></td>
                    </tr> -->
                  </tbody>
                </table>

              </div>

            </div>
          </div><!-- End Recent Sales -->

          <!-- Top Selling -->
          <!-- <div class="col-12">
            <div class="card top-selling overflow-auto">

              <div class="filter">
                <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                  <li class="dropdown-header text-start">
                    <h6>Filter</h6>
                  </li>

                  <li><a class="dropdown-item" href="#">Today</a></li>
                  <li><a class="dropdown-item" href="#">This Month</a></li>
                  <li><a class="dropdown-item" href="#">This Year</a></li>
                </ul>
              </div>

              <div class="card-body pb-0">
                <h5 class="card-title">Top Selling <span>| Today</span></h5>

                <table class="table table-borderless">
                  <thead>
                    <tr>
                      <th scope="col">Preview</th>
                      <th scope="col">Product</th>
                      <th scope="col">Price</th>
                      <th scope="col">Sold</th>
                      <th scope="col">Revenue</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row"><a href="#"><img src="" alt=""></a></th>
                      <td><a href="#" class="text-primary fw-bold">Ut inventore ipsa voluptas nulla</a></td>
                      <td>$64</td>
                      <td class="fw-bold">124</td>
                      <td>$5,828</td>
                    </tr>
                    <tr>
                      <th scope="row"><a href="#"><img src="" alt=""></a></th>
                      <td><a href="#" class="text-primary fw-bold">Exercitationem similique doloremque</a></td>
                      <td>$46</td>
                      <td class="fw-bold">98</td>
                      <td>$4,508</td>
                    </tr>
                    <tr>
                      <th scope="row"><a href="#"><img src="" alt=""></a></th>
                      <td><a href="#" class="text-primary fw-bold">Doloribus nisi exercitationem</a></td>
                      <td>$59</td>
                      <td class="fw-bold">74</td>
                      <td>$4,366</td>
                    </tr>
                    <tr>
                      <th scope="row"><a href="#"><img src="" alt=""></a></th>
                      <td><a href="#" class="text-primary fw-bold">Officiis quaerat sint rerum error</a></td>
                      <td>$32</td>
                      <td class="fw-bold">63</td>
                      <td>$2,016</td>
                    </tr>
                    <tr>
                      <th scope="row"><a href="#"><img src="" alt=""></a></th>
                      <td><a href="#" class="text-primary fw-bold">Sit unde debitis delectus repellendus</a></td>
                      <td>$79</td>
                      <td class="fw-bold">41</td>
                      <td>$3,239</td>
                    </tr>
                  </tbody>
                </table>

              </div>

            </div>
          </div>End Top Selling -->

        </div>
      </div><!-- End Left side columns -->

      <!-- Right side columns -->
      <div class="col-lg-4">

        <!-- Recent Activity -->
        <div class="card">

          <div class="card-body">
            <h5 class="card-title">Book Info</h5>

            <!-- <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">

              <img src="" alt="Book Image" class="rounded-circle">
              <h2>Kevin Anderson</h2>
              <h3>Web Designer</h3>
            </div> -->
            <BookInfo v-if="showBookInfo" :bookData="bookData" >
            </BookInfo>
         
            <!--  -->
            
            <!--  -->

          </div>
        </div><!-- End Recent Activity -->


      


      </div><!-- End Right side columns -->

    </div>
  </section>

  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <footer id="footer" class="footer">
  <div class="copyright">
    &copy; Copyright <strong><span>NiceAdmin</span></strong>. All Rights Reserved
  </div>
  <div class="credits">
    <!-- All the links in the footer should remain intact. -->
    <!-- You can delete the links only if you purchased the pro version. -->
    <!-- Licensing information: https://bootstrapmade.com/license/ -->
    <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
    Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
  </div>
  </footer><!-- End Footer -->

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>
</template>

<style scope>

</style>
