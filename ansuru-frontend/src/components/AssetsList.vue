<template>
	<div id="Index">
		<el-col :span="4">
			<el-row style="padding-right: 20px;">
				<img src="../assets/avator.png" class="image" style="width: 100%;">
			</el-row>
			<el-row id="ere">
				<el-button type="primary" size="medium"> Assets </el-button>
				<el-button type="primary" size="medium" plain> 5 </el-button>
			</el-row>
			<el-row id="ere" v-if="adminLogin">
				<el-button type="primary" size="medium"> Users </el-button>
				<el-button type="primary" size="medium" plain> 6 </el-button>
			</el-row>
		</el-col>
		<el-col :span="20">
			<el-row>
				<el-pagination
	        background
	        layout="prev, pager, next"
	        :total="total"
	        @current-change="current_change">
	      </el-pagination>
			</el-row>
			<template>
				<el-table
				:data="assetData
					.filter(data => !nameSearch || data.devName.toLowerCase().includes(nameSearch.toLowerCase()))
					.filter(data => !catSearch || data.category.toLowerCase().includes(catSearch.toLowerCase()))
					.filter(data => !brandSearch || data.brand.toLowerCase().includes(brandSearch.toLowerCase()))
					.filter(data => !picSearch || data.pic.toLowerCase().includes(picSearch.toLowerCase()))
					.slice((currentPage-1)*pagesize,currentPage*pagesize)"
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
								width="220">
								<template slot="header" slot-scope="scope">
									<el-input
										v-model="nameSearch"
										size="mini"
										placeholder="Type to nameSearch"/>
									</el-input>
								</template>
								<template slot-scope="scope">
									{{ scope.row.devName }}
								</template>
							</el-table-column>
						</el-table-column>
						<el-table-column
							label="Category"
							align="center">
							<el-table-column
								width="220">
								<template slot="header" slot-scope="scope">
									<el-input
										v-model="catSearch"
										size="mini"
										placeholder="Type to catSearch"/>
									</el-input>
								</template>
								<template slot-scope="scope">
									{{ scope.row.category }}
								</template>
							</el-table-column>
						</el-table-column>
						<el-table-column
							label="Brand"
							align="center">
							<el-table-column
								width="220">
								<template slot="header" slot-scope="scope">
									<el-input
										v-model="brandSearch"
										size="mini"
										placeholder="Type to brandSearch"/>
									</el-input>
								</template>
								<template slot-scope="scope">
									{{ scope.row.brand }}
								</template>
							</el-table-column>
						</el-table-column>
						<el-table-column
							label="PIC"
							align="center">
							<el-table-column
								width="220">
								<template slot="header" slot-scope="scope">
									<el-input
										v-model="picSearch"
										size="mini"
										placeholder="Type to picSearch"/>
									</el-input>
								</template>
								<template slot-scope="scope">
									{{ scope.row.pic }}
								</template>
							</el-table-column>
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
								align="center"
								width="100">
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
					</el-table-column>
				</el-table>
			</template>
		</el-col>
		
	</div>
</template>

<script>
export default {
	name: 'Index',
	data: function() {
		return {
			adminLogin: false,
			nameSearch: '',
			catSearch: '',
			brandSearch: '',
			picSearch: '',
			assetData: [{
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
				category: 'Projector',
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
				category: 'Printer',
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
			}, {
				regDate: '2016-05-01',
				devName: 'Asus',
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
				regDate: '2016-05-01',
				devName: 'Asus',
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
				regDate: '2016-05-01',
				devName: 'Asus',
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
				regDate: '2016-05-01',
				devName: 'Asus',
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
				regDate: '2016-05-01',
				devName: 'Asus',
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
				regDate: '2016-05-01',
				devName: 'Asus',
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
				regDate: '2016-05-01',
				devName: 'Asus',
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
				regDate: '2016-05-01',
				devName: 'Asus',
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
				regDate: '2016-05-01',
				devName: 'Asus',
				category: 'Laptop',
				brand: 'Lenovo',
				pic: 'Kyawt',
				updDate: '2016-05-03',
			}],


      total: 0,
      pagesize:10,
      currentPage:1,
		}
	},
	mounted() {
		this.total = this.assetData.length
		console.log("total count2 : " + this.total)
	},
	methods: {
		removeItem(index, row) {
			console.log("remove index:: " + index)
			console.log("remove row:: " + row)
			console.log("remove index string:: " + JSON.stringify(row))
		},
		editItem(index, row) {
			console.log("edit index:: " + index)
			console.log("edit row:: " + row)
		},
		current_change:function(currentPage){
      this.currentPage = currentPage;
    },
	}
}
</script>

<style scoped>
#ere {
	text-align: center;
	padding-top: 50px;
}
</style>











