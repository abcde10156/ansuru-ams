<template>
  <div id="userList">
  	<el-tabs type="border-card">
		  <el-tab-pane label="User List">
		  	<el-table
					:data="userList.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
					border
					style="width: 100%">
					<el-table-column
						prop="id"
						label="UserID">
					</el-table-column>
					<el-table-column
						label="Name">
						<el-table-column
							prop="name">
							<template slot="header" slot-scope="scope">
				        <el-input
				          v-model="search"
				          size="mini"
				          placeholder="Type to search"/>
				        </el-input>
				      </template>
						</el-table-column>
					</el-table-column>
					<el-table-column
						prop="position"
						label="Position">
					</el-table-column>
					<el-table-column
						prop="handleDevices"
						label="handleDevices">
					</el-table-column>
					<el-table-column
			    	label="Operation"
			    	v-if="adminLogin"
			    	align="center">
			      <el-table-column
			      	label="Edit"
			      	align="center"
			      	width="120">
			      	<template slot-scope="scope">
				      	<el-button type="primary" size="mini" plain @click="editItem(scope.$index, scope.row)">
				      		Edit
				      	</el-button>
				      </template>
			      </el-table-column>
			    	<el-table-column
			    		label="Remove"
			    		align="center"
			      	width="120">
			    		<template slot-scope="scope">
				      	<el-button type="danger" size="mini" plain @click="removeItem(scope.$index, scope.row)">
				      		Remove
				      	</el-button>
				      </template>
			      </el-table-column>
			    </el-table-column>
				</el-table>
		  </el-tab-pane>
		  <el-tab-pane label="Admin List">
		  	<el-table
					:data="userList.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
					border
					style="width: 100%">
					<el-table-column
						prop="id"
						label="UserID">
					</el-table-column>
					<el-table-column
						label="Name">
						<el-table-column
							prop="name">
							<template slot="header" slot-scope="scope">
				        <el-input
				          v-model="search"
				          size="mini"
				          placeholder="Type to search"/>
				        </el-input>
				      </template>
						</el-table-column>
					</el-table-column>
					<el-table-column
						prop="position"
						label="Position">
					</el-table-column>
					<el-table-column
						prop="handleDevices"
						label="handleDevices">
					</el-table-column>
					<el-table-column
			    	label="Operation"
			    	v-if="adminLogin"
			    	align="center">
			      <el-table-column
			      	label="Edit"
			      	align="center"
			      	width="120">
			      	<template slot-scope="scope">
				      	<el-button type="primary" size="mini" plain @click="editItem(scope.$index, scope.row)">
				      		Edit
				      	</el-button>
				      </template>
			      </el-table-column>
			    	<el-table-column
			    		label="Remove"
			    		align="center"
			      	width="120">
			    		<template slot-scope="scope">
				      	<el-button type="danger" size="mini" plain @click="removeItem(scope.$index, scope.row)">
				      		Remove
				      	</el-button>
				      </template>
			      </el-table-column>
			    </el-table-column>
				</el-table>
		  </el-tab-pane>
		</el-tabs>
	</div>
</template>

<script>
export default {
  name: 'userList',
	data: function() {
		return {
			search: '',
			adminLogin: true,
			userList: [{
				id: 111,
				name: 'Aye',
				position: 'Software Programmer',
				handleDevices: 'HP ThinkPad'
			},{
				id: 222,
				name: 'Kyawt',
				position: 'Software Programmer',
				handleDevices: 'HP ThinkPad'
			},{
				id: 333,
				name: 'San',
				position: 'Software Programmer',
				handleDevices: 'HP ThinkPad'
			}],
		}
	},
	methods: {
		
	},
}
</script>

<style scoped>
	
</style>


