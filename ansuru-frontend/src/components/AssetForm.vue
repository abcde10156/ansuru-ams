<template>
	<div id="AddItem">
		<el-col :span="16" :offset="4">
			<el-card>
				<h2 id="item-title"> 
					<span v-if="assetFormMode=='add'"> Add New Asset </span>
					<span v-if="assetFormMode=='details'"> Asset Detailed Info </span>
					<span v-if="assetFormMode=='edit'"> Edit Asset Info </span>
				</h2>

				<el-form ref="assetForm" :model="assetForm" :rules="rules">
					<el-row>
						<el-col :span="6">
							<el-form-item label="Asset Code"></el-form-item>
						</el-col>
						<el-col :span="18" v-if="assetFormMode=='details'">
							{{ assetForm.assetCode }}
						</el-col>
						<el-col :span="18" v-else>
							<el-form-item prop="assetCode">
								<el-input v-model="assetForm.assetCode"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row>
						<el-col :span="6">
							<el-form-item label="Asset Name"></el-form-item>
						</el-col>
						<el-col :span="18" v-if="assetFormMode=='details'">
							{{ assetForm.assetName }}
						</el-col>
						<el-col :span="18" v-else>
							<el-form-item prop="assetName">
								<el-input v-model="assetForm.assetName"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row>
						<el-col :span="6">
							<el-form-item label="Classification"></el-form-item>
						</el-col>
						<el-col :span="18" v-if="assetFormMode=='details'">
							{{ assetForm.classification }}
						</el-col>
						<el-col :span="18" v-else>
							<el-form-item prop="classification">
								<el-select 
									v-model="assetForm.classification"
									placeholder="Select Classification"
									style="width: 100%;">
								<el-option
									v-for="cls in assetForm.classifications"
									:key="cls.value"
									:label="cls.label"
									:value="cls.value">
								</el-option>
								</el-select>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row>
						<el-col :span="6">
							<el-form-item label="Condition"></el-form-item>
						</el-col>
						<el-col :span="18" v-if="assetFormMode=='details'">
							{{ assetForm.condition }}
						</el-col>
						<el-col :span="18" v-else>
							<el-form-item prop="condition">
								<el-select 
									v-model="assetForm.condition"
									placeholder="Select Condition"
									style="width: 100%;">
								<el-option
									v-for="cond in assetForm.conditions"
									:key="cond.value"
									:label="cond.label"
									:value="cond.value">
								</el-option>
								</el-select>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row>
						<el-col :span="6">
							<el-form-item label="PIC"></el-form-item>
						</el-col>
						<el-col :span="18" v-if="assetFormMode=='details'">
							{{ assetForm.pic }}
						</el-col>
						<el-col :span="18" v-else>
							<el-form-item prop="pic">
								<el-input v-model="assetForm.pic"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row>
						<el-col :span="6">
							<el-form-item label="Start Date"></el-form-item>
						</el-col>
						<el-col :span="18" v-if="assetFormMode=='details'">
							{{ assetForm.starts }}
						</el-col>
						<el-col :span="18" v-else>
							<el-form-item prop="starts">
								<el-date-picker
						      v-model="assetForm.starts"
						      type="date"
						      placeholder="Pick start date"
						      format="yyyy/MM/dd"
      						value-format="yyyy-MM-dd"
      						style="width: 100%;">
						    </el-date-picker>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row>
						<el-col :span="6">
							<el-form-item label="End Date"></el-form-item>
						</el-col>
						<el-col :span="18" v-if="assetFormMode=='details'">
							{{ assetForm.ends }}
						</el-col>
						<el-col :span="18" v-else>
							<el-form-item prop="ends">
								<el-date-picker
						      v-model="assetForm.ends"
						      type="date"
						      placeholder="Pick end date"
						      format="yyyy/MM/dd"
      						value-format="yyyy-MM-dd"
      						style="width: 100%;">
						    </el-date-picker>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row id="text-center"  v-if="assetFormMode=='add'">
						<el-button type="primary" size="small" v-on:click="registerAssData('assetForm')">
							Register
						</el-button>
						<el-button type="danger" size="small" plain v-on:click="resetAssForm('assetForm')">
							Reset
						</el-button>
					</el-row>
					<el-row id="text-center"  v-else-if="assetFormMode=='edit'">
						<el-button type="primary" size="small" v-on:click="editAssData('assetForm')">
							Edit
						</el-button>
						<el-button type="danger" size="small" plain v-on:click="cancelEdit">
							Cancel
						</el-button>
					</el-row>

				</el-form>
			</el-card>
		</el-col>

	</div>
</template>

<script>
export default {
	name: 'AddItem',
	data: function() {
		return {
			assetFormMode: 'add',
			assetForm: {
				assetCode: '',
				assetName: '',
				classification: '',
				condition: '',
				pic: '',
				starts: '',
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

			rules: {
				assetCode: [
					{ required: true, message: 'Please input asset code..', trigger: 'blur' },
					{ max: 50, message: 'Should be at most 50 characters', trigger: 'blur' }
				],
				assetName: [
					{ required: true, message: 'Please input asset name..', trigger: 'blur' },
					{ max: 50, message: 'Should be at most 50 characters', trigger: 'blur' }
				],
				classification: [
					{ required: true, message: 'Please select classification..', trigger: 'blur' },
				],
				condition: [
					{ required: true, message: 'Please select condition..', trigger: 'blur' },
				],
				pic: [
					{ required: true, message: 'Please input pic..', trigger: 'blur' },
					// { max: 50, message: 'Should be at most 50 characters', trigger: 'blur' }
				],
				starts: [
					{ required: true, message: 'Please choose start date..', trigger: 'blur' },
				],
				ends: [
					{ required: true, message: 'Please choose end date..', trigger: 'blur' },
				],
			}
		}
	},
	mounted() {
		this.assetFormMode = this.$store.state.assetFormMode
		console.log("Asset Form Mode :: " + this.assetFormMode)

		if ( this.assetFormMode == "details" || this.assetFormMode == "edit" ) {
			// extract asset data from database
			this.assetForm.assetCode = this.$store.state.assetCode
			this.assetForm.assetName = this.$store.state.assetName
			this.assetForm.classification = this.$store.state.classification
			this.assetForm.condition = this.$store.state.condition
			this.assetForm.pic = this.$store.state.pic
			this.assetForm.starts = this.$store.state.starts
			this.assetForm.ends = this.$store.state.ends
		}
	},
	methods: {
		registerAssData(fName) {
			this.$refs[fName].validate((valid) => {
				if (valid) {
					this.$store.state.assetFormMode = "add"
					// advance search api calling
					this.$router.push({ path: "/assets-list"})
				} else {
					console.log('error submit!!');
					return false;
				}
			});
		},
		resetAssForm(fName) {
			this.$refs[fName].resetFields();
		},
		editAssData(fName) {
			this.$refs[fName].validate((valid) => {
				if (valid) {
					this.$store.state.assetFormMode = "add"
					// call the 'edit' api
					this.$router.push({ path: "/assets-list"})
				} else {
					console.log('error submit!!');
					return false;
				}
			});
		},
		cancelEdit() {
			this.$store.state.assetFormMode = "add"
			this.$router.push({ path: "/assets-list"})
		}
	},
}
</script>

<style scoped>
	#gap-adjust {
		margin-bottom: 0px;
		margin-top: 20px;
	}
	#text-center {
		text-align: center;
	}
	#item-title {
		text-align: center;
		color: #2082e5;
	}
	el-card {
		margin-bottom: 200px!important;
	}
</style>


