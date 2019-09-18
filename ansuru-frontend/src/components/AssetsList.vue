<template>
	<div id="Index">
		<el-col :span="4">
			<el-row style="padding-right: 20px;">
				<img src="../assets/avator.png" class="image" style="width: 100%;">
			</el-row>
			<el-row id="ere">
				<el-button type="success" size="medium"> Assets </el-button>
				<el-button type="success" size="medium" plain> {{ total }} </el-button>
			</el-row>
			<el-row id="ere" v-if="adminLogin">
				<router-link to="/user-list" id="rlink">
					<el-button type="success" size="medium"> Users </el-button>
					<el-button type="success" size="medium" plain> 6 </el-button>
				</router-link>
			</el-row>
			<el-row id="ere" v-if="loginStatus">
        <a href="#" @click.prevent="logoutUser()" style="text-decoration: none; color: red;">
          <h4 id="logo">Logout</h4>
        </a>
      </el-row>
		</el-col>
		<el-col :span="20">
			<el-card>
				<el-row :gutter="21">
					<el-form :model="searchForm" ref="searchForm" :rules="rules">
						<el-col :span="5">
							<el-form-item prop="assetCode">
								<el-input v-model="searchForm.assetCode" placeholder="Asset Code"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="5">
							<el-form-item prop="assetName">
								<el-input v-model="searchForm.assetName" placeholder="Asset Name"></el-input>
							</el-form-item>
						</el-col>
						<!-- <el-col :span="5">
							<el-form-item prop="category">
								<el-input v-model="searchForm.category" placeholder="category"></el-input>
							</el-form-item>
						</el-col> -->
						<el-col :span="5">
							<el-form-item prop="classification">
								<el-select 
									v-model="searchForm.classification"
									placeholder="Classification"
									style="width: 100%;">
									<el-option
									  v-for="cls in searchForm.classifications"
									  :key="cls.value"
									  :label="cls.label"
									  :value="cls.value">
									</el-option>
							  </el-select>
								<!-- <el-input v-model="searchForm.classification" placeholder="Classification"></el-input> -->
							</el-form-item>
						</el-col>
						<el-col :span="5">
							<el-form-item prop="condition">
								<el-select 
									v-model="searchForm.condition"
									placeholder="Condition"
									style="width: 100%;">
									<el-option
									  v-for="cond in searchForm.conditions"
									  :key="cond.value"
									  :label="cond.label"
									  :value="cond.value">
									</el-option>
							  </el-select>
								<!-- <el-input v-model="searchForm.condition" placeholder="Condition"></el-input> -->
							</el-form-item>
						</el-col>
						<el-col :span="5">
							<el-form-item prop="start" id="pb-0">
								<el-date-picker
						      v-model="searchForm.start"
						      type="date"
						      placeholder="Pick start date"
						      format="yyyy/MM/dd"
      						value-format="yyyy-MM-dd">
						    </el-date-picker>
							</el-form-item>
						</el-col>
						<el-col :span="5">
							<el-form-item prop="starts" id="pb-0">
								<el-date-picker
						      v-model="searchForm.starts"
						      type="date"
						      placeholder="Pick start date"
						      format="yyyy/MM/dd"
      						value-format="yyyy-MM-dd">
						    </el-date-picker>
							</el-form-item>
						</el-col>
						<el-col :span="5">
							<el-form-item prop="end" id="pb-0">
								<el-date-picker
						      v-model="searchForm.end"
						      type="date"
						      placeholder="Pick end date"
						      format="yyyy/MM/dd"
      						value-format="yyyy-MM-dd">
						    </el-date-picker>
							</el-form-item>
						</el-col>
						<el-col :span="5">
							<el-form-item prop="ends" id="pb-0">
								<el-date-picker
						      v-model="searchForm.ends"
						      type="date"
						      placeholder="Pick end date"
						      format="yyyy/MM/dd"
      						value-format="yyyy-MM-dd">
						    </el-date-picker>
							</el-form-item>
						</el-col>
						<el-col :span="4">
							<el-button type="primary" plain v-on:click="advanceSearch('searchForm')"> Advance Search </el-button>
						</el-col>
					</el-form>
				</el-row>
			</el-card>
			<el-row style="padding-top: 10px;">
				<el-col :span="6">
					<el-pagination
		        background
		        :page-sizes="[10, total]"
      			:page-size=pageSize
		        layout="prev, pager, next, sizes"
		        :total="total"
		        @current-change="handleCurrentChange"
		        @size-change="handleSizeChange">
		      </el-pagination>
				</el-col>
				<el-col :span="12">
					<el-row id="list-title"> <strong> Ansur's Assets List </strong></el-row>
				</el-col>
				<el-col :span="6">
					<el-row style="text-align: right" v-if="adminLogin">
						<el-button type="primary" size="small" v-on:click="addNewAsset()"> + Add New Asset </el-button>
					</el-row>
				</el-col>
			</el-row>
			<el-row style="padding-top: 10px;">
				<el-table
					:data="assetData
						.filter(data => !nameQuickSearch || data.assetName.toLowerCase().includes(nameQuickSearch.toLowerCase()))
						.filter(data => !clsQuickSearch || data.category.toLowerCase().includes(clsQuickSearch.toLowerCase()))
						.filter(data => !condQuickSearch || data.condition.toLowerCase().includes(condQuickSearch.toLowerCase()))
						.filter(data => !picQuickSearch || data.pic.toLowerCase().includes(picQuickSearch.toLowerCase()))
						.slice((currentPage-1)*pagesize,currentPage*pagesize)"
					:default-sort = "{prop: 'starts', order: 'descending'}"
					border
					style="width: 100%">
					<!-- <el-table-column
						label="アンスール資産リスト"
						align="center"> -->
					<el-table-column
			      type="index"
			      prop="index"
			      label=""
			      sortable
			      align="center"
			      width="50">
			    </el-table-column>
					<el-table-column
						label="Code"
						prop="assetCode"
						align="center"
						width="80">
					</el-table-column>
					<el-table-column
						label="Device Name"
						align="center">
						<el-table-column>
							<template slot="header" slot-scope="scope">
								<el-input
									v-model="nameQuickSearch"
									size="mini"
									placeholder="Quick Search"/>
								</el-input>
							</template>
							<template slot-scope="scope">
								{{ scope.row.assetName }}
							</template>
						</el-table-column>
					</el-table-column>
					<el-table-column
						label="Classification"
						align="center">
						<el-table-column>
							<template slot="header" slot-scope="scope">
								<el-input
									v-model="clsQuickSearch"
									size="mini"
									placeholder="Quick Search"/>
								</el-input>
							</template>
							<template slot-scope="scope">
								{{ scope.row.classification }}
							</template>
						</el-table-column>
					</el-table-column>
					<el-table-column
						label="Condition"
						align="center">
						<el-table-column>
							<template slot="header" slot-scope="scope">
								<el-input
									v-model="condQuickSearch"
									size="mini"
									placeholder="Quick Search"/>
								</el-input>
							</template>
							<template slot-scope="scope">
								{{ scope.row.condition }}
							</template>
						</el-table-column>
					</el-table-column>
					<el-table-column
						label="PIC"
						align="center">
						<el-table-column>
							<template slot="header" slot-scope="scope">
								<el-input
									v-model="picQuickSearch"
									size="mini"
									placeholder="Quick Search"/>
								</el-input>
							</template>
							<template slot-scope="scope">
								{{ scope.row.pic }}
							</template>
						</el-table-column>
					</el-table-column>
					<el-table-column
						label="Start Date"
						prop="starts"
						sortable
						align="center">
					</el-table-column>
					<el-table-column
						label="End Date"
						prop="ends"
						sortable
						align="center">
					</el-table-column>
					<el-table-column
						label="Operation"
						v-if="adminLogin"
						align="center">
						<el-table-column
							label="Details"
							align="center"
							width="100">
							<template slot-scope="scope">
								<el-button type="success" size="mini" plain v-on:click="itemDetails(scope.$index, scope.row)">
									Details
								</el-button>
							</template>
						</el-table-column>
						<el-table-column
							label="Edit"
							align="center"
							width="90">
							<template slot-scope="scope">
								<el-button type="primary" size="mini" plain v-on:click="editAsset(scope.$index, scope.row)">
									Edit
								</el-button>
							</template>
						</el-table-column>
						<el-table-column
							label="Remove"
							align="center"
							width="100">
							<template slot-scope="scope">
								<el-button type="danger" size="mini" plain v-on:click="removeItem(scope.$index, assetData)">
									Remove
								</el-button>
							</template>
						</el-table-column>
					</el-table-column>
					<!-- </el-table-column> -->
				</el-table>
			</el-row>
		</el-col>
		
	</div>
</template>

<script>
import { MessageBox } from 'element-ui';
export default {
	name: 'Index',
	data: function() {
		return {
			loginStatus: false,
			adminLogin: false,
			searchForm: {
				assetCode: '',
				assetName: '',
				classification: '',
				condition: '',
				start: '',
				starts: '',
				end: '',
				ends: '',
				classifications: [{
					value: 1,
					label: 'Fixed',
				},{
					value: 2,
					label: 'Abstract',
				}],
				conditions: [{
					value: 1,
					label: 'Stock',
				},{
					value: 2,
					label: 'Currently Using',
				},{
					value: 3,
					label: 'Disposal',
				}]
			},
			nameQuickSearch: '',
			clsQuickSearch: '',
			condQuickSearch: '',
			picQuickSearch: '',
			assetData: [{
				assetCode: 'itm-123',
				assetName: 'Acer NoteBook',
				classification: 'Fixed',
				condition: 'Stock',
				pic: 'Aye',
				starts: '2016-05-01',
				ends: '2019-10-01'
			}, {
				assetCode: 'itm-456',
				assetName: 'HP ThinkPad',
				classification: 'Abstract',
				condition: 'Currently Using',
				pic: 'Kyawt',
				starts: '2016-05-02',
				ends: '2019-10-02'
			}, {
				assetCode: 'itm-789',
				assetName: 'Epson Printer',
				classification: 'Abstract',
				condition: 'Disposal',
				pic: 'San',
				starts: '2016-05-03',
				ends: '2019-10-03'
			}, {
				assetCode: 'itm-123',
				assetName: 'Acer NoteBook',
				classification: 'Fixed',
				condition: 'Stock',
				pic: 'Aye',
				starts: '2016-05-04',
				ends: '2019-10-04'
			}, {
				assetCode: 'itm-456',
				assetName: 'HP ThinkPad',
				classification: 'Abstract',
				condition: 'Currently Using',
				pic: 'Kyawt',
				starts: '2016-05-05',
				ends: '2019-10-05'
			}, {
				assetCode: 'itm-789',
				assetName: 'Epson Printer',
				classification: 'Abstract',
				condition: 'Disposal',
				pic: 'San',
				starts: '2016-05-03',
				ends: '2019-10-06'
			}, {
				assetCode: 'itm-123',
				assetName: 'Acer NoteBook',
				classification: 'Fixed',
				condition: 'Stock',
				pic: 'Aye',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-456',
				assetName: 'HP ThinkPad',
				classification: 'Abstract',
				condition: 'Currently Using',
				pic: 'Kyawt',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-789',
				assetName: 'Epson Printer',
				classification: 'Abstract',
				condition: 'Disposal',
				pic: 'San',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-123',
				assetName: 'Acer NoteBook',
				classification: 'Fixed',
				condition: 'Stock',
				pic: 'Aye',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-456',
				assetName: 'HP ThinkPad',
				classification: 'Abstract',
				condition: 'Currently Using',
				pic: 'Kyawt',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-789',
				assetName: 'Epson Printer',
				classification: 'Abstract',
				condition: 'Disposal',
				pic: 'San',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-123',
				assetName: 'Acer NoteBook',
				classification: 'Fixed',
				condition: 'Stock',
				pic: 'Aye',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-456',
				assetName: 'HP ThinkPad',
				classification: 'Abstract',
				condition: 'Currently Using',
				pic: 'Kyawt',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-789',
				assetName: 'Epson Printer',
				classification: 'Abstract',
				condition: 'Disposal',
				pic: 'San',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-123',
				assetName: 'Acer NoteBook',
				classification: 'Fixed',
				condition: 'Stock',
				pic: 'Aye',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-456',
				assetName: 'HP ThinkPad',
				classification: 'Abstract',
				condition: 'Currently Using',
				pic: 'Kyawt',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-789',
				assetName: 'Epson Printer',
				classification: 'Abstract',
				condition: 'Disposal',
				pic: 'San',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-123',
				assetName: 'Acer NoteBook',
				classification: 'Fixed',
				condition: 'Stock',
				pic: 'Aye',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-456',
				assetName: 'HP ThinkPad',
				classification: 'Abstract',
				condition: 'Currently Using',
				pic: 'Kyawt',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-789',
				assetName: 'Epson Printer',
				classification: 'Abstract',
				condition: 'Disposal',
				pic: 'San',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-123',
				assetName: 'Acer NoteBook',
				classification: 'Fixed',
				condition: 'Stock',
				pic: 'Aye',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-456',
				assetName: 'HP ThinkPad',
				classification: 'Abstract',
				condition: 'Currently Using',
				pic: 'Kyawt',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-789',
				assetName: 'Epson Printer',
				classification: 'Abstract',
				condition: 'Disposal',
				pic: 'San',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-123',
				assetName: 'Acer NoteBook',
				classification: 'Fixed',
				condition: 'Stock',
				pic: 'Aye',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-456',
				assetName: 'HP ThinkPad',
				classification: 'Abstract',
				condition: 'Currently Using',
				pic: 'Kyawt',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-789',
				assetName: 'Epson Printer',
				classification: 'Abstract',
				condition: 'Disposal',
				pic: 'San',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-123',
				assetName: 'Acer NoteBook',
				classification: 'Fixed',
				condition: 'Stock',
				pic: 'Aye',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-456',
				assetName: 'HP ThinkPad',
				classification: 'Abstract',
				condition: 'Currently Using',
				pic: 'Kyawt',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-789',
				assetName: 'Epson Printer',
				classification: 'Abstract',
				condition: 'Disposal',
				pic: 'San',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-123',
				assetName: 'Lenovo NoteBook',
				classification: 'Fixed',
				condition: 'Stock',
				pic: 'Aye',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-456',
				assetName: 'HP ThinkPad',
				classification: 'Abstract',
				condition: 'Currently Using',
				pic: 'Kyawt',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}, {
				assetCode: 'itm-789',
				assetName: 'Epson Printer',
				classification: 'Abstract',
				condition: 'Disposal',
				pic: 'San',
				starts: '2016-05-03',
				ends: '2019-10-10'
			}],

      total: 0,
      pagesize: 10,
      currentPage: 1,

      rules: {
				assetCode: [
	        { max: 50, message: 'Should be at most 50 characters', trigger: 'blur' }
	      ],
	      assetName: [
	        { max: 50, message: 'Should be at most 50 characters', trigger: 'blur' }
	      ],
			}
		}
	},
	mounted() {
		this.total = this.assetData.length
		console.log("total count2 : " + this.total)

		this.loginStatus = this.$store.state.loginStatus
		this.adminLogin = this.$store.state.adminLogin
		console.log("AssetsList adminLogin ::" + this.$store.state.adminLogin)
	},
	methods: {
		logoutUser() {
      this.$store.state.loginStatus = false
      this.$store.state.adminLogin = false
			this.$router.push({path: '/'})
    },
		advanceSearch(formName) {
			this.$refs[formName].validate((valid) => {
        if (valid) {
        	// advance search api calling
        } else {
          console.log('error submit!!');
          return false;
        }
      });
		},
		addNewAsset() {
			this.$store.state.assetFormMode = "add"
			this.$router.push({path: '/asset-form'})
		},
		itemDetails(index, row) {
			console.log("details index:: " + index)
			console.log("details row assetCode:: " + row.assetCode)
			this.$store.state.assetFormMode = "details"
			this.$store.state.assetCode = row.assetCode
			this.$store.state.assetName = row.assetName
			this.$store.state.classification = row.classification
			this.$store.state.condition = row.condition
			this.$store.state.pic = row.pic
			this.$store.state.starts = row.starts
			this.$store.state.ends = row.ends
			this.$router.push({path: '/asset-form'})
			// console.log("details row stringify:: " + JSON.stringify(row))

		},
		editAsset(index, row) {
			console.log("edit index:: " + index)
			console.log("edit row assetCode:: " + row.assetCode)
			this.$store.state.assetFormMode = "edit"
			this.$store.state.assetCode = row.assetCode
			this.$store.state.assetName = row.assetName
			this.$store.state.classification = row.classification
			this.$store.state.condition = row.condition
			this.$store.state.pic = row.pic
			this.$store.state.starts = row.starts
			this.$store.state.ends = row.ends
			this.$router.push({path: '/asset-form'})
		},
		removeItem(index, rows) {
			console.log("remove index:: " + index)
			console.log("remove row:: " + rows)
			MessageBox.confirm('Asset will be permanently delete. Continue?', {
        confirmButtonText: 'OK',
        cancelButtonText: 'Cancel',
      }).then(() => {
        this.$message({
          type: 'successs',
          message: 'Delete completed'
        });
        // deleting from el-table
        rows.splice(index, 1);
        // delete api calling
      }).catch(() => {
        this.$message({
          type: 'info',
          message: 'Delete canceled'
        });          
      });
		},
		handleCurrentChange(currentPage){
      this.currentPage = currentPage;
    },
    handleSizeChange(count) {
    	if (count > 10) {
    		this.pagesize = this.total
    	} else {
    		this.pagesize = 10
    	}
    }
	}
}
</script>

<style scoped>
#list-title {
	text-align: center;
	color: #2082e5;
	font-size: 20px;
}
#ere {
	text-align: center;
	padding-top: 50px;
}
#pb-0 {
	margin-bottom: 0px!important;
}
</style>











