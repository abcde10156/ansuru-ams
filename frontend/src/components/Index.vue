<template>
	<div id="Index">
		<!-- <h3 id="index-title"> アンスール資産リスト </h3> -->
		<el-row v-if="adminLogin" style="margin-bottom: 10px; text-align: right;">
			<router-link to="/add-item">
				<el-button type="primary" size="medium">
					+ Add New Item
				</el-button>
			</router-link>
		</el-row>
		<template>
		  <el-table
		    :data="heritageData.filter(data => !search || data.devName.toLowerCase().includes(search.toLowerCase()))"
		    height="500"
		    border
		    style="width: 100%">
		    <el-table-column
		    	label="アンスール資産リスト"
		    	align="center">
			    <el-table-column
			      prop="regDate"
			      label="Registered Date">
			    </el-table-column>
			    <el-table-column
			      label="Device Name"
			      align="center">
			      <el-table-column
			      	prop="devName"
			      	width="200">
			      	<template slot="header" slot-scope="scope">
				        <el-input
				          v-model="search"
				          size="mini"
				          placeholder="Type to search"/>
				        </el-input>
				      </template>
			      </el-table-column>
			      <template slot-scope="props">
			      	{{ props.row.devName }}
			      </template>
			    </el-table-column>
			    <el-table-column
			      prop="category"
			      label="Category"
			      align="center">
			    </el-table-column>
			    <el-table-column
			      prop="brand"
			      label="Brand"
			      align="center">
			    </el-table-column>
			    <el-table-column
			      prop="pic"
			      label="PIC"
			      align="center">
			    </el-table-column>
			    <el-table-column
			      prop="updDate"
			      label="Updated Date"
			      align="center">
			    </el-table-column>
			    <el-table-column
			    	label="Operation"
			    	v-if="adminLogin"
			    	align="center">
			      <el-table-column
			      	label="Edit"
			      	align="center">
			      	<template slot-scope="scope">
				      	<el-button type="primary" size="mini" plain @click="editItem(scope.$index, scope.row)">
				      		Edit
				      	</el-button>
				      </template>
			      </el-table-column>
			    	<el-table-column
			    		label="Remove"
			    		align="center">
			    		<template slot-scope="scope">
				      	<el-button type="danger" size="mini" plain @click="removeItem(scope.$index, scope.row)">
				      		Remove
				      	</el-button>
				      </template>
			      </el-table-column>
			    </el-table-column>
			  </el-table-column>
		  </el-table>
		</template>
	</div>
</template>

<script>
export default {
	name: 'Index',
	data: function() {
		return {
			adminLogin: true,
			search: '',
      heritageData: [{
        regDate: '2016-05-03',
        devName: 'Lenovo NoteBook',
        category: 'Laptop',
        brand: 'Lenovo',
        pic: 'Kyawt',
        updDate: '2016-05-03',
      }, {
        regDate: '2016-05-02',
        devName: 'HP ThinkPad',
        category: 'Laptop',
        brand: 'HP',
        pic: 'Kyawt',
        updDate: '2016-05-03',
      }, {
        regDate: '2016-05-04',
        devName: 'Lenovo NoteBook',
        category: 'Laptop',
        brand: 'Lenovo',
        pic: 'Kyawt',
        updDate: '2016-05-03',
      }, {
        regDate: '2016-05-01',
        devName: 'HP ThinkPad',
        category: 'Laptop',
        brand: 'HP',
        pic: 'Kyawt',
        updDate: '2016-05-03',
      }, {
        regDate: '2016-05-02',
        devName: 'Lenovo NoteBook',
        category: 'Laptop',
        brand: 'Lenovo',
        pic: 'Kyawt',
        updDate: '2016-05-03',
      }, {
        regDate: '2016-05-04',
        devName: 'Lenovo NoteBook',
        category: 'Laptop',
        brand: 'Lenovo',
        pic: 'Kyawt',
        updDate: '2016-05-03',
      }, {
        regDate: '2016-05-01',
        devName: 'Lenovo NoteBook',
        category: 'Laptop',
        brand: 'Lenovo',
        pic: 'Kyawt',
        updDate: '2016-05-03',
      }, {
        regDate: '2016-05-02',
        devName: 'Lenovo NoteBook',
        category: 'Laptop',
        brand: 'Lenovo',
        pic: 'Kyawt',
        updDate: '2016-05-03',
      }, {
        regDate: '2016-05-04',
        devName: 'Lenovo NoteBook',
        category: 'Laptop',
        brand: 'Lenovo',
        pic: 'Kyawt',
        updDate: '2016-05-03',
      }, {
        regDate: '2016-05-01',
        devName: 'Lenovo NoteBook',
        category: 'Laptop',
        brand: 'Lenovo',
        pic: 'Kyawt',
        updDate: '2016-05-03',
      }]
    }
	},
	methods: {
		removeItem(index, row) {
			console.log("remove index:: " + index)
			console.log("remove row:: " + row)
		},
		editItem(index, row) {
			console.log("edit index:: " + index)
			console.log("edit row:: " + row)
		}
	}
}
</script>

<style scoped>
	#index-title {
		text-align: center;
		color: #2082e5;
	}
	.el-card {
		background-color: #e6fcb6!important;
	}
	#fixedplus {
    position: fixed;
    bottom: 0px;
    right: 0px; 
	}
</style>